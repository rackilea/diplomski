import java.util.Map;
import javax.wsdl.Definition;
import javax.wsdl.Types;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

public class WSDLInspect {
       public static void main( String[] args ) throws Exception {
          WSDLFactory factory = WSDLFactory.newInstance();
          WSDLReader reader = factory.newWSDLReader();

         // pass the URL to the reader for parsing and get back a WSDL definiton
         Definition wsdlInstance
              = reader.readWSDL( null, "xxx" );

         // get a map of the five specific parts a WSDL file
         Types types = wsdlInstance.getTypes();
         Map messages = wsdlInstance.getMessages();
         Map portTypes = wsdlInstance.getPortTypes();
         Map bindings = wsdlInstance.getBindings();
         Map services = wsdlInstance.getServices();

         /** Do other stuff with information **/

       }
    }