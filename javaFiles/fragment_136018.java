package forum11192623;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

public class Demo {

    public static void main(String[] args) {
        try {
            TestRoot root = new TestRoot();
            root.name.value = "bobby";
            root.age.value = 102;
            root.color.value = "blue";

            JAXBContext context = JAXBContext.newInstance(root.getClass());
            Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            marsh.marshal(root,pw);
            System.out.println(sw.toString());
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
    }

    @XmlRootElement
    static class TestRoot {
        @XmlElement public TestString name = new TestString(true);
        @XmlElement public TestInteger age = new TestInteger(true);
        @XmlElement public TestString color = new TestString(true);
    }

    @XmlAccessorType(XmlAccessType.NONE)
    @XmlTransient
    @XmlSeeAlso({TestInteger.class, TestString.class})
    static class TestGeneric<T> {
        @XmlAttribute 
        public boolean isRequired;
        public T value;

        public TestGeneric() {
        }

        public TestGeneric(boolean isRequired) {
            this.isRequired = isRequired;
        }
    }

    static class TestInteger extends TestGeneric<Integer> {
        public TestInteger() {
        }
        public TestInteger(boolean b) {
            super(b);
        }
        @XmlElement
        public Integer getValue() {
            return value;
        }
        public void setValue(Integer value) {
            this.value = value;
        }
    }

    static class TestString extends TestGeneric<String> {
        public TestString() {
        }
        public TestString(boolean b) {
            super(b);
        }
        @XmlElement
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
    }

}