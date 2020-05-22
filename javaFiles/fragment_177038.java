public boolean equals(Object o)
{
    if (o == this) return true;
    if (o == null) return false;
    if (o.getClass() != getClass()) {
        return false;
    }
    ObjectNode other = (ObjectNode) o;
    if (other.size() != size()) {
        return false;
    }
    if (_children != null) {
        for (Map.Entry<String, JsonNode> en : _children.entrySet()) {
            String key = en.getKey();
            JsonNode value = en.getValue();

            JsonNode otherValue = other.get(key);

            if (otherValue == null || !otherValue.equals(value)) {
                return false;
            }
        }
    }
    return true;
}