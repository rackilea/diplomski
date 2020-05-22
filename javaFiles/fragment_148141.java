import java.util.Iterator;

import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPHeader;
import org.apache.axiom.soap.SOAPHeaderBlock;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;

public class MustUnderstandHandler extends org.apache.axis2.handlers.AbstractHandler  {

  @Override
  public InvocationResponse invoke(MessageContext messageContext) throws AxisFault {

    try{

      System.out.println("RemoveMustUnderstandAll: invoke " + messageContext);

      SOAPEnvelope env = messageContext.getEnvelope();
      SOAPHeader header = env.getHeader();

      if(header != null){

          for(Iterator<?> itr = header.getChildElements(); itr.hasNext();){

              SOAPHeaderBlock headerBlock = (SOAPHeaderBlock) itr.next();

              if(headerBlock.getMustUnderstand()){

                headerBlock.setMustUnderstand(false);
                System.out.println("RemoveMustUnderstandAll (" + messageContext + "): setMustUnderstand(false) to " + headerBlock.getQName());
              }
          }
      }
    }
    catch(Exception e){

      System.out.println(e.toString());
    }

    return InvocationResponse.CONTINUE;
  }
}