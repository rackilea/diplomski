public class DocumentationConverter implements Converter {

public boolean canConvert(Class clazz) {
    return clazz.equals(Documentation.class);
}

public void marshal(Object value, HierarchicalStreamWriter writer,
        MarshallingContext context) {
    Documentation documentation = (Documentation) value;
    writer.addAttribute("language", documentation.getLanguage());
    writer.setValue(documentation.getValue());
}

public Object unmarshal(HierarchicalStreamReader reader,
        UnmarshallingContext context) {
    Documentation documentation = new Documentation();
    reader.moveDown();
    documentation.setLanguage(reader.getAttribute("language"));
    documentation.setValue(reader.getValue());
    reader.moveUp();
    return documentation;
}

}