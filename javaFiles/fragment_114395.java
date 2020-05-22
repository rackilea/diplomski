class ValueConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return Test.class.isAssignableFrom(type);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        Test src = (Test) source;
        writer.addAttribute("id", src.id);
        writer.setValue(src.value);

        if (src.expression.string.value.length() > 0) {
            writer.startNode("expression");
            writer.startNode("string");
            writer.setValue(src.expression.string.value);
            writer.endNode();
        }

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Test test = new Test();
        test.id = reader.getAttribute("id");
        test.value = reader.getValue();
        if (reader.hasMoreChildren()) {
            reader.moveDown();
            reader.moveDown();
            test.expression.string.value = reader.getValue();

        }
        return test;
    }

}