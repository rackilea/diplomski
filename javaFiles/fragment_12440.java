public PropertyName findNameForDeserialization(Annotated a) {
    ...
    // Get JsonProperty value for the field
    JsonProperty pann = (JsonProperty)this._findAnnotation(a, JsonProperty.class);
    if (pann != null) {
        // here we are !!!
        return PropertyName.construct(pann.value());
    } else {
        return !useDefault && !this._hasOneOf(a, ANNOTATIONS_TO_INFER_DESER) ? null : PropertyName.USE_DEFAULT;
    }
}