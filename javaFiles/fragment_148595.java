import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

public class XmlInvalidGenerator {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JDOMException {
        final String xmlString = ""
                + "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                + "<start>"
                + "<level>5</level>"
                + "<mode>passive</mode>"
                + "<directory>home/lib/dir</directory>"
                + "<reach_port>8888</reach_port>"
                + "<languages default=\"en\">en,ar,bn</languages>"
                + "<Server_port>8800</Server_port>"
                + "<reset_time>180</reset_time>"
                + "<refresh_rate>10</refresh_rate>"
                + "</start>";

        final Document document = new SAXBuilder().build(new StringReader(xmlString));

        final Element start = document.getRootElement();

        final String level = start.getChild("level").getValue();
        final String mode = start.getChild("mode").getValue();
        final String directory = start.getChild("directory").getValue();
        final String reach_port = start.getChild("reach_port").getValue();
        final Element languages = start.getChild("languages");
        final String server_port = start.getChild("Server_port").getValue();
        final String reset_time = start.getChild("reset_time").getValue();
        final String refresh_rate = start.getChild("refresh_rate").getValue();

        final StringBuilder stringBuilder = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
        stringBuilder.append("<1start?").append("\n");
        stringBuilder.append("<level>").append(level).append("</level>").append("\n");
        stringBuilder.append("<mode>").append(mode).append("</mode>").append("\n");
        stringBuilder.append("<directory>").append(directory).append("</directory>").append("\n");
        stringBuilder.append("<reach_port=\"").append(reach_port).append("\"/>").append("\n");
        stringBuilder.append("<languages default=\"").append(languages.getAttribute("default").getValue()).append("\">").append(languages.getValue()).append("</languages").append("\n");
        stringBuilder.append("<Server_port=\"").append(server_port).append("\"/>").append("\n");
        stringBuilder.append("<reset_time=\"").append(reset_time).append("\"/>").append("\n");
        stringBuilder.append("<refresh_rate=\"").append(refresh_rate).append("\"/>").append("\n");

        stringBuilder.append("</1start>");

        System.out.println("stringBuilder = " + stringBuilder);
    }

    private static void printStartElement(Element start) {
        System.out.println("start.getChildren().size() = " + start.getChildren().size());
        System.out.println("level = " + start.getChild("level").getValue());
        System.out.println("mode = " + start.getChild("mode").getValue());
        System.out.println("directory = " + start.getChild("directory").getValue());
        System.out.println("reach_port = " + start.getChild("reach_port").getValue());
        final Element languages = start.getChild("languages");
        System.out.println("languages(default=" + languages.getAttribute("default").getValue() + "): " + languages.getValue());
        System.out.println("Server_port = " + start.getChild("Server_port").getValue());
        System.out.println("reset_time = " + start.getChild("reset_time").getValue());
        System.out.println("refresh_rate = " + start.getChild("refresh_rate").getValue());
    }
}