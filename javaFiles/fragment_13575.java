public class MyClassToSerialize{

    @JsonSerialize(using = MapToCoupleArraySerializer .class)
    private Map<Key, Value> recipes;

    // ...
}