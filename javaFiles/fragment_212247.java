public static class MapEntryConverter implements Converter {

    public boolean canConvert(Class clazz) {
        return AbstractMap.class.isAssignableFrom(clazz);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        AbstractMap map = (AbstractMap) value;
        for (Object obj : map.entrySet()) {
            Entry entry = (Entry) obj;
            writer.startNode(entry.getKey().toString());
            writer.setValue(entry.getValue().toString());
            writer.endNode();
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

      Repository repo = new Repository();
      while (reader.hasMoreChildren()) {
        reader.moveDown();
        String nodeName = reader.getNodeName();
        if ("name".equalsIgnoreCase(nodeName)) {
          repo.setName(reader.getValue());
        } else if ("policy".equalsIgnoreCase(nodeName)) {
          repo.setPolicy(reader.getValue());
        } else if ("layout".equalsIgnoreCase(nodeName)) {
          repo.setLayout(reader.getValue());
        } else if ("type".equalsIgnoreCase(nodeName)) {
          repo.setType(reader.getValue());
        }
        reader.moveUp();
  }
      return repo;
    }

}