public class ElConverter implements Converter {

    @Override
    public Object unmarshall(HierarchicalStreamReader reader, UnmarshallingContext context) {
        int attInt = Integer.parseInt(reader.getAttribute("attInt"));
        double attDbl = Double.parseDouble(reader.getAttribute("attDbl"));

        ...
    }

    @Override
    public boolean canConvert(Class type) {
        return El.class.isAssignableFrom(type);
    }