import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class Test {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Div.class);

        Div div = new Div();
        div.setClassName("new-item");
        StringWriter sw = new StringWriter();
        context.createMarshaller().marshal(div, sw);
        System.out.println(sw.toString());

        String s = "<div class=\"hello\"> Hi </div>";
        Div object = (Div) context.createUnmarshaller().unmarshal(new StringReader(s));
        System.out.println(object.getClassName());

    }

    @XmlType(name = "div")
    @XmlRootElement(name = "div")
    public static class Div {

        private String className;

        @XmlAttribute(name = "class")
        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }
    }
}