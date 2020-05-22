public class MySAXTerminatorException extends SAXException {
    ...
}

public void startElement (String namespaceUri, String localName,
                           String qualifiedName, Attributes attributes)
                        throws SAXException {
    if (someConditionOrOther) {
        throw new MySAXTerminatorException();
    }
    ...
}