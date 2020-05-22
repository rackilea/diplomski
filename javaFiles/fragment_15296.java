@Entity
@Data
@Table(name="bin_info")
public class BinInfo implements Serializable, Persistable<String> {
    @Id
    @NaturalId
    @NotBlank //this is for absent parameter. Not equal to Pattern regex check
    @Pattern(regexp = "^\\d{6,8}$") //6-8 digits
    @Column(name="bin")
    //@JsonProperty("bin")
    private String bin;

    ...