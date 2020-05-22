import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.simpleframework.xml.transform.Transform;

public class CustomDateFormatTransformer implements Transform<Date> {

private DateFormat df;
public DateFormatTransformer(DateFormat df) {
    this.df= df;
}

@Override
public Date read(String value) throws Exception {
    return df.parse(value);
}
@Override
public String write(Date value) throws Exception {
    return df.format(value);
}
}