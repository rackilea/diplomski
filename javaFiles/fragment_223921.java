package forum12512299;

import java.io.*;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.transform.Source;
import javax.xml.transform.stream.*;

public class MemberHandler implements DomHandler<String, StreamResult> {

    private static final String MEMBER_START_TAG = "<member>";
    private static final String MEMBER_END_TAG = "</member>";

    private StringWriter xmlWriter;

    public StreamResult createUnmarshaller(ValidationEventHandler errorHandler) {
        xmlWriter = new StringWriter();
        return new StreamResult(xmlWriter);
    }

    public String getElement(StreamResult rt) {
        String xml = rt.getWriter().toString();
        int beginIndex = xml.indexOf(MEMBER_START_TAG) + MEMBER_START_TAG.length();
        int endIndex = xml.indexOf(MEMBER_END_TAG);
        return xml.substring(beginIndex, endIndex);
    }

    public Source marshal(String n, ValidationEventHandler errorHandler) {
        try {
            String xml = MEMBER_START_TAG + n.trim() + MEMBER_END_TAG;
            StringReader xmlReader = new StringReader(xml);
            return new StreamSource(xmlReader);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}