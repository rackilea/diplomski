// print document
InputSource inputSource = new InputSource(stream);
Source saxSource = new SAXSource(inputSource);
Result result = new StreamResult(System.out);
TransformerFactory transformerFactory = TransformerFactory
    .newInstance();
Transformer transformer = transformerFactory
    .newTransformer();
transformer.transform(saxSource, result);