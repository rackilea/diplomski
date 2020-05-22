import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMText;


public class Example {
    public static void main(String[] args) {
       try {
            OMFactory factory = OMAbstractFactory.getOMFactory();

            OMNamespace ns1 = factory.createOMNamespace("bar", "x");
            OMElement root = factory.createOMElement("root", ns1);
            OMNamespace ns2 = root.declareNamespace("bar1", "y");

            OMElement elt1 = factory.createOMElement("foo", ns1);
            OMElement elt2 = factory.createOMElement("yuck", ns2);
            OMElement elt3 = factory.createOMElement("yuck2", ns2);

            OMText txt1 = factory.createOMText(elt2, "blah");
            OMText txt2 = factory.createOMText(elt3, "blah-blah");

            elt2.addChild(txt1);
            elt3.addChild(txt2);
            elt1.addChild(elt2);
            elt1.addChild(elt3);

            root.addChild(elt1);    

            OutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream("C:\\xml.xml");
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            root.serialize(outputStream); 

            root.serialize(System.out);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}