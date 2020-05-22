public final class CodigoDTO {
    private String codigo;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String accion;
    @Valid
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserDTO user;
}