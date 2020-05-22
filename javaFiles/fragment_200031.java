final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
final DocumentBuilder builder = factory.newDocumentBuilder();
final Document doc = builder.getDOMImplementation().createDocument(null, null, null);

final Binder<Node> binder = jaxbContext.createBinder();
binder.marshal(jaxbObject, doc);
final Comment comment = doc.createComment("This is a comment");
doc.appendChild(comment);

final DOMSource domSource = new DOMSource(doc);
// use System.out for testing
final StreamResult streamResult = new StreamResult(System.out);
final TransformerFactory tf = TransformerFactory.newInstance();
final Transformer serializer = tf.newTransformer();
serializer.transform(domSource, streamResult);