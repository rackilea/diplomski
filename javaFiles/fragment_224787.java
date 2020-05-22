package tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import xml.utils.XmlDocument;
import xml.utils.XmlException;
import xml.utils.XmlNode;

public class DataSet {
    private int weekNumber;
    private List<Float> employeeRatesLevelA;
    private List<Float> employeeRatesLevelB;

    public DataSet(File xml) throws XmlException {
        employeeRatesLevelA = new ArrayList<Float>();
        employeeRatesLevelB = new ArrayList<Float>();

        loadFromXml(xml);
    }

    private void loadFromXml(File xml) throws XmlException {
        XmlDocument document = new XmlDocument();
        XmlNode root = document.parse(xml);

        weekNumber = Integer.parseInt(root.getTagValue("WeekNumber"));

        XmlNode ratesLevelNode = root.getNodesByTagName("EmployeeRatesLevelA").get(0);
        List<XmlNode> rates = ratesLevelNode.getNodesByTagName("Rate");
        for (XmlNode xmlNode : rates) {
            employeeRatesLevelA.add(Float.parseFloat(xmlNode.getNodeValue()));
        }

        ratesLevelNode = root.getNodesByTagName("EmployeeRatesLevelB").get(0);
        rates = ratesLevelNode.getNodesByTagName("Rate");
        for (XmlNode xmlNode : rates) {
            employeeRatesLevelB.add(Float.parseFloat(xmlNode.getNodeValue()));
        }
    }

    public void display() {
        System.out.println("WeekNumber: " + weekNumber);
        System.out.println("Level A");
        for (Float rate : employeeRatesLevelA) {
            System.out.println("\tRate: " + rate);
        }

        System.out.println("Level B");
        for (Float rate : employeeRatesLevelB) {
            System.out.println("\tRate: " + rate);
        }
    }
}