import javax.xml.soap.SOAPConnectionFactory;
  import javax.xml.soap.SOAPConnection;
  import javax.xml.soap.MessageFactory;
  import javax.xml.soap.SOAPMessage;
  import javax.xml.soap.SOAPPart;

  import java.io.FileInputStream;
  import javax.xml.transform.stream.StreamSource;

  import javax.xml.transform.TransformerFactory;
  import javax.xml.transform.Transformer;
  import javax.xml.transform.Source;

  import javax.xml.transform.stream.StreamResult;

  public class Client {

    public static void main(String[] args) {

      try {
 // Create the connection
 SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
 SOAPConnection conn = scf.createConnection();

 // Create message
 MessageFactory mf = MessageFactory.newInstance();
 SOAPMessage msg = mf.createMessage();

 // Object for message parts
 SOAPPart sp = msg.getSOAPPart();
 StreamSource prepMsg = new StreamSource(
   new FileInputStream("path/prepared.msg"));
 sp.setContent(prepMsg);

 // Save message
 msg.saveChanges();

 // View input
 System.out.println("\n Soap request:\n");
 msg.writeTo(System.out);
 System.out.println();

 // Send
 String urlval = "http://www.pascalbotte.be/rcx-ws/rcx";
 SOAPMessage rp = conn.call(msg, urlval);

 // View the output
 System.out.println("\nXML response\n");

 // Create transformer
 TransformerFactory tff = TransformerFactory.newInstance();
 Transformer tf = tff.newTransformer();

 // Get reply content
 Source sc = rp.getSOAPPart().getContent();

 // Set output transformation
 StreamResult result = new StreamResult(System.out);
 tf.transform(sc, result);
 System.out.println();

 // Close connection
 conn.close();

      }
      catch (Exception e) {
 System.out.println(e.getMessage());
      }
    }
  }