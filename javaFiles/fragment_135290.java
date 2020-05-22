package forum9906642;

import java.net.URI;
import javax.xml.bind.annotation.adapters.*;
import javax.xml.stream.*;

public class UriAdapter extends XmlAdapter<String, URI> implements StreamFilter {

    private String base = "";

    public UriAdapter() {
    }

    public UriAdapter(String base) {
        this.base = base;
    }

    public URI unmarshal(String string) throws Exception {
        return new URI(base + '/' + string);
    }

    public String marshal(URI uri) throws Exception {
        if("".equals(base)) {
            return uri.toString();
        } else {
            URI baseURI = new URI(base);
            return baseURI.relativize(uri).toString();
        }
    }

    public boolean accept(XMLStreamReader reader) {
        if(reader.isStartElement()) {
            String newBase = reader.getAttributeValue("http://www.w3.org/XML/1998/namespace", "base");
            if(null != newBase) {
                base = newBase;
            }
        }
        return true;
    }

}