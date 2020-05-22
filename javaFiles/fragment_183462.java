import java.io.StringReader;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader xml = new StringReader("<foo><bar>toast</bar></foo>");
        Foo foo = (Foo) unmarshaller.unmarshal(xml);

        System.out.println(foo.isBar());
    }

}