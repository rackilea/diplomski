@XmlAccessorType(XmlAccessType.FIELD)
class Rate {
  @XmlElement(name = "Currency")
  private String currency;
  @Xml Element(name = "Code")
  private String code;
  @XmlElement(name = "Mid")
  private Double mid;

  public Currency getCurrency() {
    return Currency.getInstance(currency);
  }
}