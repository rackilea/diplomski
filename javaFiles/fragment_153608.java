import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {

    public static void main(String... args) throws IOException, SAXException, ParserConfigurationException {

        String xml = "<Tr rn=\"000000000000000\" vr=\"T\" sSpre=\"S\" reg=\"P\" dSpre=\"2000-01-01\" dOdprt=\"2000-01-01\" iban=\"SI00\" eno=\"R\" vir=\"B\" maticnaPps=\"0000000000\"><Imetnik davcna=\"00000000\" matSub=\"0000000000\" drz=\"705\"><PopolnoIme>UNKNOWN</PopolnoIme><KratkoIme>UNKNOWN</KratkoIme><Naslov sifTipNaslova=\"00\" sifObcina=\"000\" sifPosta=\"0000\" sifUlica=\"0000\" sifNaselje=\"000\" stHisna=\"000\" sifHsmid=\"00000000\"><Obcina>UNKNOWN</Obcina><Posta>UNKNOWN</Posta><Ulica>UNKNOWN</Ulica><Naselje>UNKNOWN</Naselje></Naslov></Imetnik></Tr>";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));

        print(doc.getDocumentElement(), "");
    }

    private static void print(Node e, String tab) {

        if (e.getNodeType() == Node.TEXT_NODE) {
            System.out.println(tab + e.getNodeValue());
            return;
        }


        System.out.print(tab + e.getNodeName());

        NamedNodeMap as = e.getAttributes();
        if (as != null && as.getLength() > 0) {
            System.out.print(" attributes=[");
            for (int i = 0; i < as.getLength(); i++) 
                System.out.print((i == 0 ? "" : ", ") + as.item(i));
            System.out.print("]");
        }
        System.out.println();

        if (e.getNodeValue() != null)
            System.out.println(tab + " " + e.getNodeValue());

        NodeList childs = e.getChildNodes();
        for (int i = 0; i < childs.getLength(); i++)
            print(childs.item(i), tab + " ");
    }
}