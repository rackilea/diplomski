import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class javaTest extends AbstractMessageTransformer{
    public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException{
        String testS = message.getInvocationProperty("test");
        return testS;
    }
}