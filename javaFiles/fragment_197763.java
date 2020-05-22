public static class BoxConverter implements Converter {

    public boolean canConvert(Class clazz) {
            return clazz.equals(Box.class);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer,
                    MarshallingContext context) {
            throw new RuntimeException("to do");
    }

    public Object unmarshal(HierarchicalStreamReader reader,
                    UnmarshallingContext context) {
            Box box = new Box();
             while (reader.hasMoreChildren()) {
                    reader.moveDown();
                    if ("doubleFieldA".equals(reader.getNodeName())) {
                            reader.moveDown();
                            Double val = Double.valueOf(reader.getValue());
                            reader.moveUp();
                            GenericClass<Double> genericObject = new GenericClass<>();
                            genericObject.myGenericField = val;
                            box.doubleFieldA = genericObject;
                    } else if ("doubleFieldB".equals(reader.getNodeName())) {
                            box.doubleFieldB =(NonGenericClass)context.convertAnother(box, NonGenericClass.class);
                    }
                    reader.moveUp();
            }
            return box;
    }
}