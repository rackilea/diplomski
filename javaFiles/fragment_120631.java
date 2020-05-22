package xsltplayground;

import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTplayground {

    public static void main(String[] args) throws Exception {

        URL url = XSLTplayground.class.getResource("sample.xml");
        File input = new File(url.toURI());
        URL url2 = XSLTplayground.class.getResource("stylesheet.xsl");
        File xslt = new File(url2.toURI());
        URL url3 = XSLTplayground.class.getResource(".");
        File output = new File(new File(url3.toURI()), "output.xml");
        change(input, output, xslt);

    }

    private static void change(File pathIn, File pathOut, File xsltFile) {
        try {

            // Creating transformer with XSLT file
            TransformerFactory tf = TransformerFactory.newInstance();
            Source xsltSource = new StreamSource(xsltFile);
            Transformer t = tf.newTransformer(xsltSource);

            // Input source
            Source input = new StreamSource(pathIn);

            // Output target
            Result output = new StreamResult(pathOut);

            // Transforming
            t.transform(input, output);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XSLTplayground.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XSLTplayground.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}