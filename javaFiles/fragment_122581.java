@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "messageType")
@JsonSubTypes({
    @JsonSubTypes.Type(value=ContractUpdateMessage.class, name = "ContractUpdateMessage"),
    @JsonSubTypes.Type(value=SingleContractUpdateMessage.class, name = "SingleContractUpdateMessage")
})
public abstract class DlqMessage { ... }