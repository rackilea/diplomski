import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;

public class XmlParser {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Pair.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Object o = unmarshaller.unmarshal(new StringReader("<pair><a>Hello</a><b>World</b></pair>"));
        System.out.println(o);
    }

    @XmlRootElement
    public static class Pair {
        public String a;
        public String b;

        @Override
        public String toString() {
            return "Pair{" + "a='" + a + '\'' + ", b='" + b + '\'' + '}';
        }
    }
}