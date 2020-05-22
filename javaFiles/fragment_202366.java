/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikunj.m
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xmlTojsonDom1 {

public static void main(String[] args) {
    try {
        File file = new File("D:/Noname1.xml");
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        if (doc.hasChildNodes()) {
            JSONArray ddd = printNote_1(doc.getChildNodes());
            System.out.println("ddd ::::: " + ddd);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

private static JSONArray printNote_1(NodeList nodeList) {
    JSONArray dataArr = new JSONArray();
    JSONObject dataObject = new JSONObject();
    for (int count = 0; count < nodeList.getLength(); count++) {
        Node tempNode = nodeList.item(count);
        if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
            if (tempNode.hasChildNodes() && tempNode.getChildNodes().getLength() > 1) {
                JSONArray temArr = printNote_1(tempNode.getChildNodes());
                if (dataObject.containsKey(tempNode.getNodeName())) {
                    dataObject.getJSONArray(tempNode.getNodeName()).add(temArr.getJSONObject(0));
                } else {
                    dataObject.put(tempNode.getNodeName(), temArr);
                }
            } else {
                dataObject.put(tempNode.getNodeName(), tempNode.getTextContent());
            }
        }
    }
    dataArr.add(dataObject);
    return dataArr;
}