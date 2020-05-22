Exception in thread "main" org.xml.sax.SAXParseException; lineNumber: 1; columnNumber: 1; Invalid byte 1 of 1-byte UTF-8 sequence.
        at java.xml/com.sun.org.apache.xerces.internal.parsers.DOMParser.parse(DOMParser.java:262)
        at java.xml/com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl.parse(DocumentBuilderImpl.java:339)
        at java.xml/javax.xml.parsers.DocumentBuilder.parse(DocumentBuilder.java:122)
        at TestXmlParser.main(TestXmlParser.java:14)
Caused by: com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException: Invalid byte 1 of 1-byte UTF-8 sequence.
        at java.xml/com.sun.org.apache.xerces.internal.impl.io.UTF8Reader.invalidByte(UTF8Reader.java:702)
        at java.xml/com.sun.org.apache.xerces.internal.impl.io.UTF8Reader.read(UTF8Reader.java:568)
        at java.xml/com.sun.org.apache.xerces.internal.impl.XMLEntityScanner.load(XMLEntityScanner.java:1904)
        at java.xml/com.sun.org.apache.xerces.internal.impl.XMLEntityScanner.arrangeCapacity(XMLEntityScanner.java:1770)
        at java.xml/com.sun.org.apache.xerces.internal.impl.XMLEntityScanner.skipString(XMLEntityScanner.java:1808)
        at java.xml/com.sun.org.apache.xerces.internal.impl.XMLVersionDetector.determineDocVersion(XMLVersionDetector.java:158)
        at java.xml/com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:860)
        at java.xml/com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:824)
        at java.xml/com.sun.org.apache.xerces.internal.parsers.XMLParser.parse(XMLParser.java:141)
        at java.xml/com.sun.org.apache.xerces.internal.parsers.DOMParser.parse(DOMParser.java:246)
        ... 3 more