import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.StringReader;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(ReqEle1.class);
        String xml0 = "<ele1><ele2><ele3>534159XXXXXX0176</ele3></ele2></ele1>";
        String xml1 = "<ele1><ele2><ele_3>534159XXXXXX0176</ele_3></ele2></ele1>";
        String xml2 = "<ele1><ele2><ele03>534159XXXXXX0176</ele03></ele2></ele1>";

        for (String xml : new String[]{xml0, xml1, xml2}) {
            StringReader reader = new StringReader(xml);
            Object unmarshal = jaxbContext.createUnmarshaller().unmarshal(reader);
            System.out.println(unmarshal);
        }
    }
}

@XmlRootElement(name = "ele1")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"ele2"})
class ReqEle1 {

    @XmlJavaTypeAdapter(ReqEle2XmlAdapter.class)
    @XmlElement(name = "ele2", required = true)
    protected ReqEle2 ele2;

    // getters, setters
}

class ReqEle2XmlAdapter extends XmlAdapter<Object, ReqEle2> {

    @Override
    public ReqEle2 unmarshal(Object v) {
        Element element = (Element) v;
        ReqEle2 reqEle2 = new ReqEle2();
        reqEle2.setEle3(element.getFirstChild().getTextContent());

        return reqEle2;
    }

    @Override
    public Object marshal(ReqEle2 v) throws Exception {
        return null; // Implement if needed
    }
}

class ReqEle2 {

    protected String ele3;

    // getters, setters
}