import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

public class ChangeXMLAttribute {

    public static void changeAttribute() throws FileNotFoundException, JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new FileInputStream(new File("path/to/directory","filename")));

        XPathFactory xpf = XPathFactory.instance();
        XPathExpression<Attribute> xpath = xpf.compile(
                "/Test1/task[@uuid=\"92F7F685-C370-4E55-9026-020E3CDCEDE0\"]/@status",
                Filters.attribute(), null);

        Attribute taskStatus = xpath.evaluateFirst(doc);

        System.out.println("Before: " + taskStatus.getValue());

        taskStatus.setValue("1000");

        System.out.println("After: " + taskStatus.getValue());
    }
}