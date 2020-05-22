package xml2html;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class Xml2HtmlConverter {

public static void main(String[] args, String xmlpath)
{
    pathmethod(xmlpath);
}

public static void pathmethod(String xmlpath) 
{
try
    {
        TransformerFactory tFactory = TransformerFactory.newInstance();

        Source xslDoc = new StreamSource("D:/xmlautomation/stylesheet.xsl");
        Source xmlDoc = new StreamSource(xmlpath);

        String outputFileName = "D:/xmlautomation/output.html";
        OutputStream htmlFile = new FileOutputStream(outputFileName);

        Transformer transformer = tFactory.newTransformer(xslDoc);
        transformer.transform(xmlDoc, new StreamResult(htmlFile));
        htmlFile.close();     
    }

catch(Exception e)
{
    e.printStackTrace();
}

finally
{

}
}
}