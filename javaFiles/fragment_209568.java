package fedexPackage;
import java.io.IOException;
import javax.xml.soap.*;
public class Fedex {
    private static String KEY = "xxxxxxxxxxxxxxxxxx";
    private static String PASSWORD ="xxxxxxxxxxxxxx";
    private static String ACCOUNTNUMBER ="xxxxxxxxxxxx";
    private static String METERNUMBER ="xxxxxxxxxxxx";
    private static String CTID = "Track By Number_v16";
    private static String LANGUAGECODE = "EN";
    private static String LOCALECODE = "US";
    private static String SERVICEID ="trck";
    private static String MAJOR = "16";
    private static String INTERMEDIATE ="0";
    private static String MINOR ="0";
    private static String TYPE ="TRACKING_NUMBER_OR_DOORTAG";
    private static String VALUE ="xxxxxxxxxxx";
    private static String GC ="rates evertitque aequora";
    public static void main(String[] args)
    {
        String soapEndpointUrl = "https://wsbeta.fedex.com:443/web-services"; 
        String soapAction = "http://schemas.xmlsoap.org/soap/envelope/"; 
        SOAPConnectionFactory soapConnectionFactory;
        try {
            soapConnectionFactory = SOAPConnectionFactory.newInstance();
               SOAPConnection soapConnection = soapConnectionFactory.createConnection();
                SOAPMessage soapRequest = createSOAPRequest(soapAction);
                SOAPMessage soapResponse = soapConnection.call(soapRequest, soapEndpointUrl);
                System.out.println("Response SOAP Message:");
                try {
                    soapResponse.writeTo(System.out);
                } catch (IOException e) {

                    e.printStackTrace();
                }
                System.out.println();
                soapConnection.close();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }

    }

    private static SOAPMessage createSOAPRequest(String soapAction) throws SOAPException 
    {
         MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            createSoapEnvelope(soapMessage);

            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", soapAction);

            soapMessage.saveChanges();
            System.out.println("Request SOAP Message:");
            try {
                soapMessage.writeTo(System.out);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("\n");
            return soapMessage;
    }

    private static void createSoapEnvelope(SOAPMessage soapMessage)
    {   
         SOAPPart soapPart = soapMessage.getSOAPPart();
         String myNamespace = "v16";
         String myNamespaceURI = "http://fedex.com/ws/track/v16";

            try {
                SOAPEnvelope envelope = soapPart.getEnvelope();
                envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
                SOAPBody soapBody = envelope.getBody();
                SOAPElement TrackRequest = soapBody.addChildElement("TrackRequest", myNamespace);
                SOAPElement WebAuthenticationDetail = TrackRequest.addChildElement("WebAuthenticationDetail", myNamespace);
                SOAPElement UserCredential = WebAuthenticationDetail.addChildElement("UserCredential", myNamespace);
                SOAPElement Key = UserCredential.addChildElement("Key",myNamespace);
                Key.addTextNode(KEY);
                SOAPElement Password = UserCredential.addChildElement("Password",myNamespace);
                Password.addTextNode(PASSWORD);
                SOAPElement ClientDetail = TrackRequest.addChildElement("ClientDetail", myNamespace);
                SOAPElement AccountNumber = ClientDetail.addChildElement("AccountNumber", myNamespace);
                AccountNumber.addTextNode(ACCOUNTNUMBER);
                SOAPElement MeterNumber = ClientDetail.addChildElement("MeterNumber", myNamespace);
                MeterNumber.addTextNode(METERNUMBER);
                SOAPElement TransactionDetail = TrackRequest.addChildElement("TransactionDetail", myNamespace);
                SOAPElement CustomerTransactionId = TransactionDetail.addChildElement("CustomerTransactionId", myNamespace);
                CustomerTransactionId.addTextNode(CTID);
                SOAPElement Localization = TransactionDetail.addChildElement("Localization", myNamespace);
                SOAPElement LanguageCode = Localization.addChildElement("LanguageCode",myNamespace);
                LanguageCode.addTextNode(LANGUAGECODE);
                SOAPElement LocaleCode = Localization.addChildElement("LocaleCode", myNamespace);
                LocaleCode.addTextNode(LOCALECODE);
                SOAPElement Version = TrackRequest.addChildElement("Version", myNamespace);
                SOAPElement ServiceId = Version.addChildElement("ServiceId", myNamespace);
                ServiceId.addTextNode(SERVICEID);
                SOAPElement Major = Version.addChildElement("Major", myNamespace);
                Major.addTextNode(MAJOR);
                SOAPElement Intermediate = Version.addChildElement("Intermediate", myNamespace);
                Intermediate.addTextNode(INTERMEDIATE);
                SOAPElement Minor = Version.addChildElement("Minor", myNamespace);
                Minor.addTextNode(MINOR);
                SOAPElement SelectionDetails = TrackRequest.addChildElement("SelectionDetails", myNamespace);
                SOAPElement PackageIdentifier = SelectionDetails.addChildElement("PackageIdentifier", myNamespace);
                SOAPElement Type = PackageIdentifier.addChildElement("Type", myNamespace);
                Type.addTextNode(TYPE);
                SOAPElement Value = PackageIdentifier.addChildElement("Value", myNamespace);
                Value.addTextNode(VALUE);
                SOAPElement ShipmentAccountNumber = SelectionDetails.addChildElement("ShipmentAccountNumber", myNamespace);
                SOAPElement SecureSpodAccount = SelectionDetails.addChildElement("SecureSpodAccount", myNamespace);
                SOAPElement Destination = SelectionDetails.addChildElement("Destination", myNamespace);
                SOAPElement GeographicCoordinates = Destination.addChildElement("GeographicCoordinates", myNamespace);
                GeographicCoordinates.addTextNode(GC);
            }
            catch (SOAPException e) 
            {
                e.printStackTrace();
            }
    }
}