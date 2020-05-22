import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Base64;

public class Base64ByteArrayAdapter extends XmlAdapter<String, byte[]> {

    @Override
    public byte[] unmarshal(String base64) throws Exception {
        return Base64.getDecoder().decode(base64);
    }

    @Override
    public String marshal(byte[] bytes) throws Exception {
        return Base64.getEncoder().encodeToString(bytes);
    }
}