@XmlRootElement
public class MyPojo {
    public String name;
    @XmlJavaTypeAdapter(CurrencyAdapter.class)
    public Currency currency;
}