@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConnectionAcceptedResponseMessage.class, name = "CONNECTION_ACCEPTED"),
        @JsonSubTypes.Type(value = OtherResponseMessage.class, name = "OTHER")
})