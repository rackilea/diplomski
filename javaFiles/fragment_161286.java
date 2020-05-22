import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CurrencyAdapter extends XmlAdapter<String, Currency>{

    @Override
    public Currency unmarshal(String v) throws Exception {
        Currency c = new Currency();
        c.type = v;
        return c;
    }

    @Override
    public String marshal(Currency v) throws Exception {
        return v.type;
    }  
}