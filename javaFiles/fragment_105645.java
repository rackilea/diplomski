import java.io.ByteArrayOutputStream;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

@ServiceMode(value=Service.Mode.PAYLOAD)
@WebServiceProvider()
public class SoapProvider implements Provider<Source>
{
    public Source invoke(Source msg)
    {
        StreamResult sr = new StreamResult();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        sr.setOutputStream(out);

        try {
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.transform(msg, sr);

            // Use out to your heart's desire.
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }    

        return msg;
    }
}