public class Bean {
    public String simpleField;

    @MapAppender(keys = {"test1", "test2"}, values = {"value1", "value2"})
    @JsonSerialize(using = MapAppenderSerializer.class)
    public Map<Object, Object> simpleMap = new HashMap<>();
}