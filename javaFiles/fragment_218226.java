class JsonRootRecipes {

    @JsonProperty("deleted")
    public List<Number> deleted;

    @JsonProperty("meta")
    public JsonMeta meta;

    @JsonProperty("objects")
    public List<Object> objects;

    // getters, setters, toString
}

class JsonMeta {

    @JsonProperty("is_anonymous")
    private boolean anonymous;

    // getters, setters, toString
}

// another POJOs decoupled from Android classes.