import java.time.Duration
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeFactory;

public class DurationAdapter extends XmlAdapter<javax.xml.datatype.Duration, Duration>
{
    @Override
    public Duration unmarshal(javax.xml.datatype.Duration v) throws Exception {
        return Duration.parse(v.toString());
    }

    @Override
    public javax.xml.datatype.Duration marshal(Duration v) throws Exception {
        return DatatypeFactory.newInstance().newDuration(v.toString());
    }
}