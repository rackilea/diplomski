package com.stackof.helps.nonspring;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @author samuele m.
 *
 */
public class MixedTest
{
    @Test
    public void testPathItem() throws Exception {
        String xml = "<PARENT><TAG_1><ROLE>Architect </ROLE></TAG_1><TAG1><ROLE>Engineer </ROLE></TAG1></PARENT>";
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setIgnoringElementContentWhitespace(true);
        dbFactory.setIgnoringComments(true);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = dBuilder.parse(is);
        NodeList nodeList1 = doc.getElementsByTagName("TAG1");
        NodeList nodeList2 = doc.getElementsByTagName("TAG_1");
        Assert.assertEquals(1, nodeList1.getLength());
        Assert.assertEquals(1, nodeList2.getLength());

        NodeList engList = ((Element)nodeList1.item(0)).getElementsByTagName("ROLE");
        NodeList arcList = ((Element)nodeList2.item(0)).getElementsByTagName("ROLE");
        Assert.assertEquals(1, engList.getLength());
        Assert.assertEquals(1, arcList.getLength());

        String eng = engList.item(0).getTextContent().trim();
        String arc = arcList.item(0).getTextContent().trim();
        Assert.assertEquals("Architect", arc);
        Assert.assertEquals("Engineer", eng);
    }
}