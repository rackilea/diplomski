@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRates {
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;

    @XmlElement(name="currency")
    private List<Currency> currencies = new ArrayList<>();

    ....
}

@XmlAccessorType(XmlAccessType.FIELD)
public class Currency {
    @XmlAttribute
    private String code;

    @XmlElement(name="rate")
    private List<Rate> rates= new ArrayList<>();

    ....
}


@XmlAccessorType(XmlAccessType.FIELD)
public class Rate {
    @XmlAttribute
    private String code;

    @XmlValue
    private Double value;

    ....
}