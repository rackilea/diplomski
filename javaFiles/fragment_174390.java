@XmlRootElement(name = "ArrayOfExchangeRatesTable")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootElement {
  @XmlElement(name = "ExchangeRatesTable")
  private TableRateModel tableRateModel;
}

@XmlAccessorType(XmlAccessType.FIELD)
class TableRateModel {
  @XmlElement(name = "Table")
  private String table;
  @XmlElement(name = "EffectiveDate")
  private Date effectiveDate;
  @XmlElement(name = "Rates")
  private Rates rates;
}

@XmlAccessorType(XmlAccessType.FIELD)
class Rates {
  @XmlElement(name = "Rate")
  private List<Rate> rates;
}

@XmlAccessorType(XmlAccessType.FIELD)
class Rate {
  @XmlElement(name = "Currency")
  private String currency;
  @XmlElement(name = "Code")
  private String code;
  @XmlElement(name = "Mid")
  private Double mid;
}