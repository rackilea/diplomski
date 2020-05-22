class DateAdapter extends XmlAdapter<String, Date> {
    DateFormat f = new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSS");

    @Override
    public Date unmarshal(String v) throws Exception {
        return f.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return f.format(v);
    }
}

class Type {
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date dateprix;
...