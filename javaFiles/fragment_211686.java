final class MyEntity {

    String someString;

    int someInt;

    @Lob
    @JsonAdapter(PackedJsonTypeAdapterFactory.class)
    String clientData;

}