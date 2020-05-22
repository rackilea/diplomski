class TestMessage {

    private String action; 

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_POPERTY, propery = "action")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = TestMessageStreamMetadata.class, name = "stream"),
        @JsonSubTypes.Type(value = TestMessageFooMetadata.class, name = "foo")
    })
    private TestMessageMetadata metadata;

}