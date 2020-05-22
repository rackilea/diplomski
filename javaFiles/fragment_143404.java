@JsonProperty(value="account_id")
    @Valid
    @NotNull
    private String accountId;

    @JsonProperty(value="last_updated_at")
    @Valid
    @NotNull    
    private OffsetDateTime lastUpdatedAt;