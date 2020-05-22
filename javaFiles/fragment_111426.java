@Column(name = "ITEM_NO")
private String itemNo; 
@Id
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="PROMOTION_ID")
private PromotionEntity promotion;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="SELL_PRICE_ID")
private SellPriceEntity sellPrice;