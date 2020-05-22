package util;

public class DoubleW implements QueryStringBindable<DoubleW> {

    public Double value = null;

    @Override
    public Option<DoubleW> bind(String key, Map<String, String[]> data) {
        String[] vs = data.get(key);
        if (vs != null && vs.length > 0) {
            String v = vs[0];
            value = Double.parseDouble(v);
            return F.Some(this);
        }
        return F.None();
    }

    @Override
    public String unbind(String key) {
        return key + "=" + value;
    }

    @Override
    public String javascriptUnbind() {
         return value.toString();
    }

}