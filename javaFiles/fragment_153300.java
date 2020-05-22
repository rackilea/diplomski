package com.test;

import java.io.IOException;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AverageUsage {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;
        int usageSum = 0;
        int usageCount = 0;

        // Create calendar representing now (used later)
        Calendar threeMonthsBefore = Calendar.getInstance();

        // Subtract 3 months from now
        threeMonthsBefore.add(Calendar.MONTH, -3);

        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();

            // Create xpath expression to query our totals
            XPathExpression expr = xpath.compile("/USAGE_LIST/TOTAL");

            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            // Iterate over all TOTAL elements
            for(int i = 0; i < nodes.getLength(); i++){
                // Current total element
                Element total = (Element)nodes.item(i);

                // Get YEAR, MONTH, USAGE elements from current TOTAL element
                Element year = (Element)total.getElementsByTagName("YEAR").item(0);
                Element month = (Element)total.getElementsByTagName("MONTH").item(0);
                Element usage = (Element)total.getElementsByTagName("USAGE").item(0);

                // Read values as int
                int yearValue = Integer.valueOf(year.getTextContent());
                int monthValue = Integer.valueOf(month.getTextContent());
                int usageValue = Integer.valueOf(usage.getTextContent());

                // Get calendar instance & reset it
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
                cal.clear(Calendar.MINUTE);
                cal.clear(Calendar.SECOND);
                cal.clear(Calendar.MILLISECOND);
                cal.clear(Calendar.DATE);

                // Set calendar date
                cal.set(Calendar.YEAR, yearValue);
                cal.set(Calendar.MONTH, monthValue);

                // Check if cal date is less than 3 months old
                if(cal.after(threeMonthsBefore)){
                    usageSum += usageValue;
                    usageCount++;
                }
            }

            if(usageCount > 0){
                float average = usageSum / (float) usageCount;
                System.out.println("Average usage in past 3 months is: " + average);

            }else{
                System.out.println("There were no usage in past 3 months.");
            }


        } catch (ParserConfigurationException | SAXException | IOException
                | XPathExpressionException e) {
            e.printStackTrace();
        }
    }

}