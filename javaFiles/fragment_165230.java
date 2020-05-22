import java.util.Calendar;
import java.util.Date;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

// ...

String dateString = "..."; // wherever you get this from
XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateString);

Calendar cal = xcal.toGregorianCalendar();
Date date = cal.getTime();