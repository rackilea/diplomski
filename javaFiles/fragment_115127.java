import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StringArrayXmlTypeAdapter extends
        XmlAdapter<List<String>, String[]> {
    @Override
    public List<String> marshal(String[] arg) throws Exception {
        return new ArrayList<String>(Arrays.asList(arg));
    }

    @Override
    public String[] unmarshal(List<String> arg) throws Exception {
        return arg.toArray(new String[] {});
    }
}