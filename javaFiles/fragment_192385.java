@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "promotionType")
@JsonSubTypes({
    @Type(value = OrderThresholdDiscountPromotionDto.class, name = "ORDER_THRESHOLD_DISCOUNT"),
})
class PromotionDto {