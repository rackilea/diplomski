private Map<String, String> attributes;

public void addAttribute(String attribute, String value) {
    if (this.attributes == null) {
        this.attributes = new HashMap<String, String>();
    }

    this.attributes.put(attribute, value);
}

public Map<String, String> getAttributes() {
    return attributes;
}

public void setAttributes(Map<String, String> attributes) {
    this.attributes = attributes;
}