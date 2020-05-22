public Foo {
    public int bar;
    private transient Map<String, Object> params = new HashMap<String, Object>();

    @JsonAnySetter
    public void set(String k, Object v) { params.put(k, v); }

    @JsonAnyGetter
    public Map getParams() { return params; }
}