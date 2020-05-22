@XmlElement(required = true)
protected TypeAuthentication authentication;
@XmlElement
protected List<TypePrimitiveField> requestPrimitiveField;
@XmlElement
protected List<TypeObjectField> requestObjectField;
@XmlElement
protected List<TypeObjectsField> requestObjectsField;
@XmlElement
protected List<TypeCollectionsField> requestCollectionsField;