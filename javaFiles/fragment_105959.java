public class MyObject {
    @JsonDeserialize(
            using = MyBooleanDeserializer.class,
            as = Boolean.class
    )
    private boolean bool;
}