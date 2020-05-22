package forum10294935;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();
        Element pingElement = document.createElement("ping");
    }

}