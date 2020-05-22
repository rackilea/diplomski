import java.io.StringReader;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        StringReader xml = new StringReader("<root><singleEmptyElement/><singlePopulatedElement>populated</singlePopulatedElement><listEmptyElement/><listPopulatedElement>populated</listPopulatedElement></root>");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Root root = (Root) unmarshaller.unmarshal(xml);

        System.out.println(root.singleMissingElement);
        System.out.println(root.singleEmptyElement);
        System.out.println(root.singlePopulatedElement);

        System.out.println(root.listMissingElement);
        System.out.println(root.listEmptyElement);
        System.out.println(root.listPopulatedElement);
    }

}