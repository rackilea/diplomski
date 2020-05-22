public static List<Object> marshal(Object value) {
    try {
        Class<?> type = value.getClass();
        if (type.isAnonymousClass())
            type = type.getSuperclass();

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Marshaller marshaller = JAXBContext.newInstance(type).createMarshaller();
        marshaller.marshal(new JAXBElement<>(QName.valueOf("root"), Object.class, value), document);

        NodeList nodes = document.getDocumentElement().getChildNodes();
        return IntStream.range(0, nodes.getLength()).mapToObj(nodes::item).collect(Collectors.toList());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

public static <T> T unmarshal(List<Object> content, Map<QName, String> attributes, Class<T> type) {
    try {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        document.appendChild(document.createElement("root"));

        if (attributes != null)
            attributes.forEach((q, s) -> document.getDocumentElement().setAttribute(q.getLocalPart(), s));

        if (content != null)
            content.forEach(o -> document.getDocumentElement().appendChild(document.importNode((Node) o, true)));

        Unmarshaller unmarshaller = JAXBContext.newInstance(type).createUnmarshaller();
        return unmarshaller.unmarshal(document, type).getValue();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}