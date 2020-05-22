package demo;
import org.alfresco.model.ContentModel;
import org.alfresco.repo.node.NodeServicePolicies;
import org.alfresco.repo.policy.*;
import org.alfresco.repo.security.authentication.PasswordGenerator;
import org.alfresco.service.cmr.repository.*;
import org.alfresco.service.cmr.security.*;
import org.alfresco.util.PropertyCheck;
import org.springframework.beans.factory.InitializingBean;

public class NewUserEmail implements 
    NodeServicePolicies.OnCreateNodePolicy, InitializingBean {

    @Override
    public void onCreateNode(ChildAssociationRef childAssocRef) {
        notifyUser(childAssocRef);
    }

    private void notifyUser(ChildAssociationRef childAssocRef) {
        NodeRef personRef = childAssocRef.getChildRef();
        // get the user name
        String username = (String) this.nodeService.getProperty(
            personRef, ContentModel.PROP_USERNAME);
        // generate the new password (Alfresco's rules)
        String newPassword = passwordGenerator.generatePassword();
        // set the new password
        authenticationService.setAuthentication(username, newPassword.toCharArray());
        // send default notification to the user
        personService.notifyPerson(username, newPassword);
    }

    private PolicyComponent policyComponent;
    private NodeService nodeService;
    private PersonService personService;
    private PasswordGenerator passwordGenerator;
    private MutableAuthenticationService authenticationService;

    public void setPolicyComponent(PolicyComponent policyComponent) {
        this.policyComponent = policyComponent;
    }

    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void setPasswordGenerator(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        if (authenticationService instanceof MutableAuthenticationService) {
            this.authenticationService = (MutableAuthenticationService) authenticationService;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PropertyCheck.mandatory(this, "policyComponent", policyComponent);
        PropertyCheck.mandatory(this, "nodeService", nodeService);
        PropertyCheck.mandatory(this, "passwordGenerator", passwordGenerator);
        PropertyCheck.mandatory(this, "authenticationService", authenticationService);
        PropertyCheck.mandatory(this, "personService", personService);

        this.policyComponent.bindClassBehaviour(
                NodeServicePolicies.OnCreateNodePolicy.QNAME,
                ContentModel.TYPE_PERSON,
                new JavaBehaviour(this,
                        NodeServicePolicies.OnCreateNodePolicy.QNAME.getLocalName(),
                        Behaviour.NotificationFrequency.TRANSACTION_COMMIT
                )
        );
    }


}