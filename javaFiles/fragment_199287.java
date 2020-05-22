public class FlatXmlConverter implements Converter {

    private static final Logger log =
            LoggerFactory.getLogger(NvpConverter.class);

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer,
            MarshallingContext context) {
        Class<? extends Object> sourceClass = source.getClass();
        String prefix = (String) context.get("prefix");
        for (Field field : sourceClass.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            String name = field.getName();
            Class<?> type = field.getType();

            try {
                Object value = field.get(source);
                if (value != null) {
                    if (type.isAnnotationPresent(XmlType.class)) {
                        context.put("prefix", name);
                        context.convertAnother(value);
                        context.put("prefix", null);
                    } else {
                        String nodeName;
                        if (prefix == null) {
                            nodeName = name;
                        } else {
                            nodeName = prefix + "_" + name;
                        }

                        writer.startNode(nodeName);
                        context.convertAnother(value);
                        writer.endNode();
                    }
                }
            } catch (IllegalArgumentException ex) {
                log.error("IllegalArgumentException", ex);
            } catch (IllegalAccessException ex) {
                log.error("IllegalAccessException", ex);
            }
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public boolean canConvert(Class type) {
        log.debug("canConvert({})", type);
        return type.isAnnotationPresent(XmlType.class);
    }
}