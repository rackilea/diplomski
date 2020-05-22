import org.w3c.dom.ls.*;
import java.io.FileOutputStream;

DOMImplementationLS ls = (DOMImplementationLS)documentoXML.getImplementation();
LSSerializer ser = ls.createLSSerializer();
LSOutput out = ls.createLSOutput();
out.setEncoding("UTF-8");
FileOutputStream output = new FileOutputStream("output.xml");
try {
  out.setByteStream(output);
  ser.write(documentoXML, out);
} finally {
  output.close();
}