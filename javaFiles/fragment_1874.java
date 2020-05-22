import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(A.class, B.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        A a = new A();
        a.setFoo("Hello World");
        marshaller.marshal(a, System.out);

        B b = new B();
        b.setFoo("Hello World");
        marshaller.marshal(b, System.out);
    }

}