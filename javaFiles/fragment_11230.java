1. Download jsoup core library  (jsoup-1.6.1.jar) from http://jsoup.org/download
2. Add the jsoup-1.6.1.jar file to your classpath.
3. Try the below code to save the xml file from the URL.

package com.overflow.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author sarath_sivan
 */
public class XmlExtractor {

    public static StringBuilder fetchXmlContent(String url) throws IOException {
        StringBuilder xmlContent = new StringBuilder();
        Document document = Jsoup.connect(url).get();
        xmlContent.append(document.body().html());
        return xmlContent;
    }

    public static void saveXmlFile(StringBuilder xmlContent, String saveLocation) throws IOException {
        FileWriter fileWriter = new FileWriter(saveLocation);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(xmlContent.toString());
        bufferedWriter.close();
        System.out.println("Downloading completed successfully..!");
    }

    public static void downloadXml() throws IOException {
        String url = "http://api.worldbank.org/countries/GBR/indicators/NY.GDP.MKTP.KD.ZG?date=2004:2012";
        String saveLocation = System.getProperty("java.io.tmpdir")+"sarath.xml";
        XmlExtractor.saveXmlFile(XmlExtractor.fetchXmlContent(url), saveLocation);
    }

    public static void main(String[] args) throws IOException {
        XmlExtractor.downloadXml();
    }

}

4. Once the above code is executed successfully, a file named "sarath.xml" should be there in your temp folder.