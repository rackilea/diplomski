import java.io.FilterWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.stream.Collectors;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class TransformWithFilter {

    private static class RemoveCRFilterWriter extends FilterWriter {

        RemoveCRFilterWriter(Writer wrappedWriter) {
            super(wrappedWriter);
        }

        @Override
        public void write(int c) throws IOException {
            if (c != (int)('\r')) {
                super.write(c);
            }
        }

        @Override
        public void write(char[] cbuf, int offset, int length) throws IOException {
            int localOffset = offset;
            for (int i = localOffset; i < offset + length; ++i) {
                if (cbuf[i] == '\r') {
                    if (i > localOffset) {
                        super.write(cbuf, localOffset, i - localOffset);
                    }
                    localOffset = i + 1;
                }
            }
            if (localOffset < offset + length) {
                super.write(cbuf, localOffset, offset + length - localOffset);
            }
        }

        @Override
        public void write(String str, int offset, int length) throws IOException {
            int localOffset = offset;
            for (int i = localOffset; i < offset + length; ++i) {
                if (str.charAt(i) == '\r') {
                    if (i > localOffset) {
                        super.write(str, localOffset, i - localOffset);
                    }
                    localOffset = i + 1;
                }
            }
            if (localOffset < offset + length) {
                super.write(str, localOffset, offset + length - localOffset);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><foo/></root>";
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        StreamSource source = new StreamSource(new StringReader(xml));
        StringWriter stringWriter = new StringWriter();
        FilterWriter writer = new RemoveCRFilterWriter(stringWriter);
        StreamResult target = new StreamResult(writer);

        transformer.transform(source, target);

        System.out.println(stringWriter.toString().chars().mapToObj(c -> c <= ' ' ? "#" + c : "" + Character.valueOf((char) c))
                .collect(Collectors.joining(" ")));
        System.out.println(stringWriter);
    }
}