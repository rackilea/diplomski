import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LastNameAdapter extends XmlAdapter<LastNameAdapter.AdaptedLastName, String> {

    @XmlType(propOrder={"lastname", "birthdate"})
    public static class AdaptedLastName {
        public String lastname;
        public String birthdate;
    }

    private String birthdate;

    public LastNameAdapter() {
    }

    public LastNameAdapter(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String unmarshal(AdaptedLastName v) throws Exception {
        return v.lastname;
    }

    @Override
    public AdaptedLastName marshal(String v) throws Exception {
        AdaptedLastName adaptedLastName = new AdaptedLastName();
        adaptedLastName.lastname = v;
        adaptedLastName.birthdate = birthdate;
        return adaptedLastName;
    }

}