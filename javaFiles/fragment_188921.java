import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class NameHandler implements DomHandler<String, StreamResult> {

      private static final String NAME_START_TAG = "<name>";
        private static final String NAME_END_TAG = "</name>";

        private StringWriter xmlWriter = new StringWriter();
    @Override
    public StreamResult createUnmarshaller(ValidationEventHandler errorHandler) {
        return new StreamResult(xmlWriter);
    }

    @Override
    public String getElement(StreamResult rt) {
         String xml = rt.getWriter().toString();
            int beginIndex = xml.indexOf(NAME_START_TAG) + NAME_START_TAG.length();
            int endIndex = xml.indexOf(NAME_END_TAG);
            return xml.substring(beginIndex, endIndex);
    }

    @Override
    public Source marshal(String n, ValidationEventHandler errorHandler) {
         try {
                String xml = NAME_START_TAG + n.trim() + NAME_END_TAG;
                StringReader xmlReader = new StringReader(xml);
                return new StreamSource(xmlReader);
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
    }

}