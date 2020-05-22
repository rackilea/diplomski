public enum RequestField {
    PLANT_ID(Request::getPlantId, (val, campaign) -> campaign.plant.id::contains),
    TITLE(Request::getTitle, (val, campaign) -> campaign.title::containsIgnoreCase),
    CAMPAIGN_NUMBER(Request::getCampaignNumber, (val, campaign) -> campaign.campaignNumber::like),
    // ... more fields here ...
    ;

    private final Function<Request, Optional<Object>> get;
    private final BiFunction<Object, Campaign, BooleanExpression> map;

    RequestField(Function<Request, Object> get, BiFunction<Object, Campaign, BooleanExpression> map) {
        this.get = get.andThen(Optional::ofNullable);
        this.map = map;
    }

    public static List<BooleanExpression> getBooleanExpressions(Request request, Campaign campaign) {
        if (request == null)
            return Collections.emptyList();

        List<BooleanExpression> res = new LinkedList<>();

        for (RequestField field : values())
            field.get.apply(request)
                     .map(r -> field.map.apply(r, campaign))
                     .ifPresent(res::add);

        return res.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(res);
    }
}