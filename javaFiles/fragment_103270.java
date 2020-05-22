import java.sql.*;

import cubrid.jdbc.driver.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class JavaSP3 {
public static String TResultSet(){
ResultSet rs = null;
Statement stmt = null;
String sql;
try {
           Class.forName("cubrid.jdbc.driver.CUBRIDDriver"); 
           Connection con = DriverManager.getConnection("jdbc:default:connection:"); 
          ((CUBRIDConnection)con).setCharset("euc_kr"); 

                  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                  DocumentBuilder builder =factory.newDocumentBuilder();
                  Document doc = builder.newDocument();
                  Element results = doc.createElement("Results");
                  doc.appendChild(results);

                  sql = "select * from athlete"; 
                   stmt=con.createStatement(); 
                   rs = stmt.executeQuery(sql); 
                  ResultSetMetaData rsmd = rs.getMetaData();
                  int colCount = rsmd.getColumnCount();

                 while (rs.next()) {
                    Element row = doc.createElement("Row");
                    results.appendChild(row);
                    for (int ii = 1; ii <= colCount; ii++) {
                       String columnName = rsmd.getColumnName(ii);
                       Object value = rs.getObject(ii);
                       Element node = doc.createElement(columnName);
                       node.appendChild(doc.createTextNode(value.toString()));
                       row.appendChild(node);
                    }
                  }


                 String valor = getDocumentAsXml(doc);
                 return valor;

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    return null;
}

public static String getDocumentAsXml(Document doc)
      throws TransformerConfigurationException, TransformerException {
    DOMSource domSource = new DOMSource(doc);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
    transformer.setOutputProperty
       ("{http://xml.apache.org/xslt}indent-amount", "4");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

    java.io.StringWriter sw = new java.io.StringWriter();
    StreamResult sr = new StreamResult(sw);
    transformer.transform(domSource, sr);
    return sw.toString();
 }

}