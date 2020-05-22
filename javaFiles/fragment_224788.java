package tests;

import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import xml.utils.XmlException;

public class Main {
    public static void main(String[] args) throws SAXException, IOException, XmlException {
        File dataFile = new File("/home/jomit/data.xml");
        DataSet dataSet = new DataSet(dataFile);
        dataSet.display();
    }
}