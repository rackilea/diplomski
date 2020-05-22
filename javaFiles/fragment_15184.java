class ElementDeserializer extends DOMDeserializer<Element> {

    private static final long serialVersionUID = 1L;

    public ElementDeserializer() {
        super(Element.class);
    }

    @Override
    public Element _deserialize(String value, DeserializationContext ctxt)
        throws IllegalArgumentException {
        return parse(value).getDocumentElement();
    }
}