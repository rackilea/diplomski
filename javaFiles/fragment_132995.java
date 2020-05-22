import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

    private static final String XML = "<?xml version=\"1.0\"?>\n" 
            + "<GET_GUESS_CHART>" 
            + "    <sort_by_letter>" 
            + "        <letter_row>"
            + "            <letter>A</letter>" 
            + "            <guess>16</guess>" 
            + "            <rank>3</rank>" 
            + "        </letter_row>"
            + "        <letter_row>" +
            + "            <letter>B</letter>" 
            + "            <guess>5</guess>" 
            + "            <rank>1</rank>"
            + "        </letter_row>" 
            + "    </sort_by_letter>" 
            + "    <sort_by_rank>" 
            + "        <letter_row>" 
            + "            <letter>A</letter>"
            + "            <guess>16</guess>" 
            + "            <rank>1</rank>" 
            + "        </letter_row>" 
            + "        <letter_row>"
            + "            <letter>E</letter>" 
            + "            <guess>15</guess>" 
            + "            <rank>2</rank>" 
            + "        </letter_row>"
            + "    </sort_by_rank>" 
            + "</GET_GUESS_CHART>";

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new ByteArrayInputStream(XML.getBytes()));

        NodeList rootElement = doc.getChildNodes();

        NodeList sortByNodes = rootElement.item(0).getChildNodes();

        for (int k = 0; k < sortByNodes.getLength(); k++) {
            Node sortBy = sortByNodes.item(k);

            System.out.println("SORT BY: " + sortBy.getNodeName());

            NodeList letterRows = sortBy.getChildNodes();

            for (int j = 0; j < letterRows.getLength(); j++) {
                Node letterRow = letterRows.item(j);
                NodeList letterRowDetails = letterRow.getChildNodes();

                if (letterRowDetails.getLength() > 0) {
                    String letter = null;
                    String guess = null;
                    String rank = null;

                    for (int i = 0; i < letterRowDetails.getLength(); i++) {
                        Node detail = letterRowDetails.item(i);

                        if (detail.getNodeName().equals("letter")) {
                            letter = detail.getTextContent();
                        } else if (detail.getNodeName().equals("guess")) {
                            guess = detail.getTextContent();
                        } else if (detail.getNodeName().equals("rank")) {
                            rank = detail.getTextContent();
                        }
                    }

                    System.out.println("Letter=" + letter + ", guess=" + guess + ", rank=" + rank);
                }
            }
        }
    }
}