@XmlElementRefs({
        @XmlElementRef(type = Span.class),
        @XmlElementRef(type = Other.class),
        @XmlElementRef(type = Another.class)

})
@XmlJavaTypeAdapter(value = SpanAdapter.class)
public List<Component> getComponents() {
    if (components == null) components = new ArrayList();
    return components;
}