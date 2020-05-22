public enum JsonType {
    GETTER, SETTER, OTHER;
}

public @interface JsonElement {
    JsonType type() default JsonType.OTHER;
}