package wsdlvalidation; 

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import javax.wsdl.Definition;
import javax.wsdl.Fault;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.Part;
import javax.wsdl.PortType;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.apache.tools.ant.types.FileSet;

/**
 * Ant Task to validate a WDSL for an Axis1 bug.
 *
*/
public class WSDLValidationTask extends MatchingTask
{
    private FileSet configuredWsdl;

    public void execute() throws BuildException
    {
        super.execute();

        try {
            WSDLFactory wsdlFactory = WSDLFactory.newInstance();
            WSDLReader reader = wsdlFactory.newWSDLReader();

            Iterator it = getWSDLFileNamesList().iterator();
            while (it.hasNext()) {
                String wsdl = (String) it.next();

                Definition theWSDL = reader.readWSDL(wsdl);


                // This is a Bag of all Messages in the WSDL that are used in some <wsdl:fault> of any Operation of any PortType
                Set faultMessages = new HashSet();
                Map allPortTypes = theWSDL.getPortTypes();
                Iterator portTypeIt = allPortTypes.entrySet().iterator();
                while (portTypeIt.hasNext()) {
                    Map.Entry entry = (Entry) portTypeIt.next();
                    PortType portType = (PortType) entry.getValue();
                    List allOperations = portType.getOperations();
                    Iterator listIt = allOperations.iterator();
                    while (listIt.hasNext()) {
                        Operation operation = (Operation)listIt.next();
                        Iterator faultIt = operation.getFaults().values().iterator();
                        while (faultIt.hasNext()) {
                            Fault fault = (Fault) faultIt.next();    
                            faultMessages.add(fault.getMessage());                    
                        }
                    }
                }

                Map allMessages = theWSDL.getMessages();
                Iterator messageIt = allMessages.entrySet().iterator();
                while (messageIt.hasNext()) {
                    Map.Entry entry = (Entry) messageIt.next();
                    QName messageNameQName = (QName) entry.getKey();
                    String messageName = messageNameQName.getLocalPart();

                    Message message = (Message) entry.getValue();
                    Map parts = message.getParts();
                    validate(parts.size() == 1, wsdl,
                            "wsdl:message has more than one part: " + messageNameQName.toString());
                    Part messagePart = (Part) parts.values().iterator().next();
                    validate(messagePart.getTypeName() == null, wsdl, "wsdl:part should not have a 'type' attribute: " + messagePart.getName());

                    // Only for Messages that are used in Fault:
                    if (faultMessages.contains(message)) {
                        validate(!messagePart.getElementName().getLocalPart().equals(messageName), wsdl,
                                "Due to an Axis1 bug, please do NOT use the same name for <wsdl:message name=\"" + messageName + "\"> and <xsd:element name=\"" + messagePart.getElementName().getLocalPart()+"\">");
                    }
                }

            }
        } catch (WSDLException e) {
            throw new BuildException(e);
        }
    }

    private void validate(boolean condition, String wsdlFilename, String failureMessage) throws BuildException {
        if (!condition) {
            throw new BuildException(wsdlFilename + ": " + failureMessage);
        }
    }

    // TODO Doesn't code like this already exist in ant??
    private List getWSDLFileNamesList() {
        List/*<String>*/ wsdlList = new ArrayList/*<String>*/();
        File dir = configuredWsdl.getDir(configuredWsdl.getProject());
        StringTokenizer tokenizer = new StringTokenizer(configuredWsdl.toString(), ";");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            wsdlList.add(new File(dir, token).toString());
        }
        return wsdlList;
    }

    public void addConfiguredWsdl(FileSet fileSet) {
        configuredWsdl = fileSet;
    }
}