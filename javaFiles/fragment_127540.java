@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MyDTO implements Serializable {

    @JsonProperty("id")
    private Long id;


    @JsonProperty("tax_id")
    private Long taxId;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("short_description")
    private Map<String,Object> shortDescription;

    public static MyDTO buildCatalogProductDTO(MyDomain md) {
    return MyDTO.builder()
            .id(md.getId())
            .taxId(catalogProduct.getTaxId())
            .shortDescription(SerializationUtil.parseJson(md.getShortDescription()))
            .build();
    }