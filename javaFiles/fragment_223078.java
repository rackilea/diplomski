import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Demo {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        File file = new File("input.xml");
        Document document = db.parse(file);

        JAXBContext jc = JAXBContext.newInstance(SomeRandomClass.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setAdapter(new XPathFragmentAdapter(document));
        SomeRandomClass src = (SomeRandomClass) unmarshaller.unmarshal(document);

        System.out.println(src.get_expression().get_parentNode() != null);
    }

}