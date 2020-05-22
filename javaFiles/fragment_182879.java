import java.util.Date;

import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import forum235.DateAdapter.AdaptedDate;

public class DateAdapter extends XmlAdapter<AdaptedDate, Date> {

    @Override
    public Date unmarshal(AdaptedDate adaptedDate) throws Exception {
        return adaptedDate.date;
    }

    @Override
    public AdaptedDate marshal(Date date) throws Exception {
        AdaptedDate adaptedDate = new AdaptedDate();
        adaptedDate.date = date;
        return adaptedDate;
    }

    static class AdaptedDate {
        @XmlValue
        public Date date;
    }

}