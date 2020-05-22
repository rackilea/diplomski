class FluentJson {
    private Object value;

    public FluentJson(Object value) {
        this.value = value;
    }

    public FluentJson get(int index) throws JSONException {
        JSONArray a = (JSONArray) value;
        return new FluentJson(a.get(index));
    }

    public FluentJson get(String key) throws JSONException {
        JSONObject o = (JSONObject) value;
        return new FluentJson(o.get(key));
    }

    public String toString() {
        return value == null ? null : value.toString();
    }

    public Number toNumber() {
        return (Number) value;
    }
}