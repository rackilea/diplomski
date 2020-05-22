public class DateAdapter extends XmlAdapter<String, Date> {

    private Locale brasil = new Locale("pt", "BR");
    private final SimpleDateFormat SD1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat SD2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Override
    public String marshal(Date v) throws Exception {
        return SD2.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception, ParseException {
        return SD1.parse(v);
    }
}