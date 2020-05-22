// temporary result list just to store the values found
ArrayList<String> result = new ArrayList<String>();

DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
Document doc = documentBuilder.parse(new ByteArrayInputStream("<document><test val=\"val1\">Test XML</test><test val=\"val2\">Test XML</test><test val=\"val3\">Test XML</test></document>".getBytes()));
// you could use something like: documentBuilder.parse(new FileInputStream("fileName.ext")); instead

// get test nodes and iterate over it checking test attribute
NodeList elements = doc.getElementsByTagName("test");
for (int i = 0; i < elements.getLength(); i++) {
    Node node = elements.item(i);
    Node attribute = node.getAttributes().getNamedItem("val");
    if (attribute != null) {
        result.add(attribute.getTextContent());
    }
}

// get result values in a string array (if collection is preferred use result instead)
String[] array = result.toArray(new String[] {});

// just print it in a readable format
System.out.println(Arrays.toString(array));