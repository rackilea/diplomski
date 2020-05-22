static class MapTestConverter implements Converter {        
    public boolean canConvert(Class type) {
        return type.equals(MapTest.class);
    }

    public void marshal(Object source, HierarchicalStreamWriter writer,
            MarshallingContext context) {
        MapTest mt = (MapTest) source;
        for (Entry<String, String> e : mt.serviceMap.entrySet()) {
            writer.startNode("id");
            writer.setValue(e.getKey());
            writer.endNode();
            writer.startNode("name");
            writer.setValue(e.getValue());
            writer.endNode();
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        MapTest mt = new MapTest();
        String id = null;

        while (reader.hasMoreChildren()) {
            reader.moveDown();
            if ("id".equals(reader.getNodeName())) {
                if (id != null) { throw new RuntimeException("Malformed XML, ID was set twice: " + id); }
                id = (String) context.convertAnother(mt, String.class);
            } else if ("name".equals(reader.getNodeName())) {
                String name = (String) context.convertAnother(mt, String.class);
                if (id == null) { throw new RuntimeException("Malformed XML: Found name without ID: " + name); }
                mt.serviceMap.put(id, name);
                id = null;
            }
            reader.moveUp();
        }
        return mt;
    }
}