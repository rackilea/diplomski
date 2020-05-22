import java.io.*;
import java.util.*;

// for imageio metadata
import javax.imageio.*;
import javax.imageio.stream.*;
import javax.imageio.metadata.*;

// for xml handling
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class imgmeta {
    // Very lazy exception handling
    // This is just a quick example
    public static void main(String[] args) throws Exception {
        String filename = args[0];

        File file = new File(filename);
        ImageInputStream imagestream = ImageIO.createImageInputStream(file);

        // get a reader which is able to read this file
        Iterator<ImageReader> readers = ImageIO.getImageReaders(imagestream);
        ImageReader reader = readers.next();

        // feed image to reader
        reader.setInput(imagestream, true);

        // get metadata of first image
        IIOMetadata metadata = reader.getImageMetadata(0);

        // get any metadata format name
        // (you should prefer the native one, but not all images have one)
        // String mdataname = metadata.getNativeMetadataFormatName(); // might be null
        String[] mdatanames = metadata.getMetadataFormatNames();

        String mdataname = mdatanames[0];

        Node metadatadom = metadata.getAsTree(mdataname);

        // metadatadom is now a DOM Node root of a DOM tree
        // representing metadata in the image
        // Since it's in-memory, it can't be "invalid"
        // because it's already been parsed


        // now let's serialize to an XML string
        // javax.xml.transform.Transformer takes xml sources
        // in one representation and transforms them to xml
        // in another representation
        // Representations include: DOM, JAXB, SAX, stream, etc
        DOMSource source = new DOMSource(metadatadom);

        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

        // THIS is what you want:
        String metadata_in_xml = writer.toString();

        // now print it:
        System.out.print(metadata_in_xml);
    }
}