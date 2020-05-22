import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Test2014062001 {

    final static String sourceXml1 ="<languages-list>\r\n" + 
            "<language>\r\n" + 
            "<family>John Family</family>\r\n" + 
            "<users>asfasd</users>\r\n" +
            "</language>\r\n" + 
            "</languages-list>";

    final static String sourceXml2 = "<languages-list>\r\n" + 
            "<language>\r\n" + 
            "<name>John</name>\r\n" + 
            "<region>NYC</region>\r\n" + 
            "</language>\r\n" + 
            "</languages-list>";

    final static String xsl =
            "<xsl:stylesheet version=\"2.0\"\r\n" + 
            "xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\r\n" + 
            "\r\n" + 
            "<xsl:param name=\"doc2\" />\r\n" + 
            "\r\n" + 
            "    <xsl:template match=\"/\">\r\n" + 
            "        <html>\r\n" + 
            "            <body>\r\n" + 
            "                <div><xsl:value-of select=\"system-property('xsl:vendor')\"/></div>\r\n" +
            "                <table border=\"1\">\r\n" +        
            "        <xsl:for-each select=\"languages-list/language\">\r\n" +
            "          <xsl:variable name=\"pos\" select=\"position()\"/>\r\n" +  
            "                    <tr>\r\n" +        
            "                        <td><xsl:value-of select=\"family\"/></td>\r\n" + 
            "                        <td><xsl:value-of select=\"users\"/></td>\r\n" + 
            "                        <td><xsl:value-of select=\"$doc2/languages-list/language[$pos]/name\"/></td>\r\n" + 
            "                        <td><xsl:value-of select=\"$doc2/languages-list/language[$pos]/region\"/></td>\r\n" + 
            "                    </tr>\r\n" + 
            "                 </xsl:for-each>\r\n" + 
            "                </table>\r\n" + 
            "            </body>\r\n" + 
            "        </html>\r\n" + 
            "    </xsl:template>\r\n" + 
            "</xsl:stylesheet> ";

    public static void main(String[] args) {
        System.out.println(sourceXml1 + "\n=======\n" + sourceXml2+"\n=======\n"+xsl);

        try {

            StreamSource stream1 = new StreamSource(new StringReader(sourceXml1));
            StreamSource stream2 = new StreamSource(new StringReader(sourceXml2));      

            StringReader xslReader = new StringReader(xsl);

            StringWriter writer = new StringWriter();
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new StreamSource(xslReader)); // style sheet

            transformer.setParameter("doc2", stream2);  

            transformer.transform(stream1, new StreamResult(writer));

            String result = writer.toString();
            System.out.println("==============\n"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}