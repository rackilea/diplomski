package mypackge;

import javax.xml.soap.SOAPException;
import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.message.SOAPHeader;
import org.apache.axis.message.SOAPHeaderElement;

public class SoapHeaderConsumerHandler
  extends BasicHandler
{
  public void invoke(MessageContext messageContext)
    throws AxisFault
  {
    // Your logic for request or response handling goes here. 
    // Basically you need to make use of the parameter
   // messageContext where you can access the soap header and body tags.
  }
}