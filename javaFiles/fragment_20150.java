import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

private final static String RFTVersionFolder = "C:\\IBM\\SDP\\FunctionalTester\\properties\\version";

public static String getRFTVersionWithXML() {
        File versionFolder = new File(RFTVersionFolder);
        File[] versionFile = versionFolder.listFiles( new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return (name.endsWith(".swtag"));
                } } );

        Document versionDocument = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            versionDocument = builder.parse(new FileInputStream(versionFile[0]));
        } catch (SAXParseException spe) {
            spe.printStackTrace();
        } catch (SAXException sxe) {
            sxe.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Node versionNode = versionDocument.getElementsByTagName("ProductVersion").item(0);

        return versionNode.getTextContent();
    }