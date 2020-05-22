@Data
@JsonView
@NoArgsConstructor
public class Data {

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonView(Views.IdOnly.class)
    private ObjectId id;

    private boolean active = true;

    @Valid
    @NotNull
    private DataMeta dataMeta;

    @Valid
    @NotNull
    private DataContent dataContent;

}