@JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "investmentType")
    @JsonTypeIdResolver(InvestmentResolver.class)
    public abstract class Investment {
    }