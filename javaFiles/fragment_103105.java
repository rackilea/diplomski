import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.security.KeyStore;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;


public class WSUtil {
    public static void main(String[] args) throws Exception {

        String req = "SOAPMESSAGE";
        Document p = createXMLDocument(req);
        InputStream inStream = new FileInputStream("certificate.p12"); //Provide your certificate file

        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(inStream, "pass".toCharArray()); //Certificate password - pass

        String alias = ks.aliases().nextElement();
        X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);

        validateSignature(p.getElementsByTagName("ds:Signature").item(0),p.getElementsByTagName("soapenv:Body").item(0),certificate.getPublicKey());//True if the message is valid
    }

    public static Document createXMLDocument(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new InputSource(
                    new StringReader(xmlString)));
        } catch (Exception e) {
            throw e;
        }
        return document;
    }

    private static boolean validateSignature(Node signatureNode, Node bodyTag, PublicKey publicKey) {
        boolean signatureIsValid = false;
        try {
            // Create a DOM XMLSignatureFactory that will be used to unmarshal the
            // document containing the XMLSignature
            String providerName = System.getProperty
                    ("jsr105Provider", "org.jcp.xml.dsig.internal.dom.XMLDSigRI");
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM",
                    (Provider) Class.forName(providerName).newInstance());

            // Create a DOMValidateContext and specify a KeyValue KeySelector
            // and document context
            DOMValidateContext valContext = new DOMValidateContext(new X509KeySelector(publicKey), signatureNode);
            valContext.setIdAttributeNS((Element) bodyTag, "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Id");

            // Unmarshal the XMLSignature.
            XMLSignature signature = fac.unmarshalXMLSignature(valContext);
            // Validate the XMLSignature.
            signatureIsValid = signature.validate(valContext); 

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return signatureIsValid;
    }
}