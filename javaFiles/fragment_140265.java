package mypkg;

import java.util.Properties;

import javax.management.ObjectName;

import com.ibm.websphere.management.AdminClient;
import com.ibm.websphere.management.AdminClientFactory;
import com.ibm.websphere.management.Session;
import com.ibm.websphere.management.configservice.ConfigServiceHelper;
import com.ibm.websphere.management.configservice.ConfigServiceProxy;

public class MyAdminClient {

    public static void main(String[] args) throws Exception {


        String aliasToFind = "blahAlias";  // Or "MyNode/blahAlias" if you use the node prefix.
        String SOAP_CONNECTOR_ADDRESS_PORT = "8879";
        String host = "localhost";

        // Initialize the AdminClient
        Properties adminProps = new Properties();
        adminProps.setProperty(AdminClient.CONNECTOR_TYPE, AdminClient.CONNECTOR_TYPE_SOAP);
        adminProps.setProperty(AdminClient.CONNECTOR_HOST, host);
        adminProps.setProperty(AdminClient.CONNECTOR_PORT, SOAP_CONNECTOR_ADDRESS_PORT);
        AdminClient adminClient = AdminClientFactory.createAdminClient(adminProps);

        // Get the ConfigService implementation
        ConfigServiceProxy configService = new ConfigServiceProxy(adminClient);

        Session session = new Session();

        // Find the parent security object
        ObjectName security = ConfigServiceHelper.createObjectName(null, "Security", null);
        ObjectName[] securityName = configService.queryConfigObjects(session, null, security, null);
        security = securityName[0];

        ObjectName authData = ConfigServiceHelper.createObjectName(null, "JAASAuthData", null);
        ObjectName[] authDataEntries = configService.queryConfigObjects(session, null, authData, null);
        ObjectName auth;

        for (int i=0; i < authDataEntries.length; i++) {
            auth = authDataEntries[i];
            Object aliasAttr = configService.getAttribute(session, auth, "alias");
            if (aliasAttr.equals(aliasToFind)) {
                System.out.println("Alias located: alias = " + configService.getAttribute(session, auth, "alias")
                + "; userId = " + configService.getAttribute(session, auth, "userId")                                
                + "; password = " + configService.getAttribute(session, auth, "password"));
                break;
            }
        }
    }
}