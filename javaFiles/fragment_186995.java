import javax.xml.bind.JAXB;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXB.unmarshal("com.sun.xml.internal.messaging.saaj.soap.ver1_2.Message1_2Impl@693f23a2", Foo.class);  
    }
}