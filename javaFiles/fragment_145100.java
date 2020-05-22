@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sample {
    private String name;

    @JsonSerialize(using = LegacyUuidSerializer.class)
    @JsonDeserialize(using = LegacyUuidDeserializer.class)
    private UUID sampleId;
}