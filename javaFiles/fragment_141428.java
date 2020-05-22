@SuppressWarnings("unchecked")
private <T> T getAttribute(PropertyKeys propertyKey){
    T result = (T) getStateHelper().eval(propertyKey);

    if (result == null) {
        result = (T) this.getAttributes().get(propertyKey + "");
    }

    return result;
}