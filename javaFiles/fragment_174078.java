@lombok.ToString
@lombok.Getter
@lombok.Setter
@lombok.Data
@ApiModel(description = "description.")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request1")
public class Request1 {

    @XmlElement(name="Identifier")
    @JsonProperty("Identifier") // <-- missing json property annotation added
    @ApiModelProperty(required = true)
    @Valid
    private String identifier;
}