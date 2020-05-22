static class EmbeddedStringExtractor extends DoFn<Entity, String> {
  @Override
  public void processElement(ProcessContext c) {
    Map<String, Value> main_entity_map = DatastoreHelper.getPropertyMap(c.element());
    List<Value> embedded_entity_values = entity.get("embedded_entity").getListValueList();

      for (Value embedded_entity_value: embedded_entity_values){
          Entity embedded_entity = embedded_entity_value.getEntityValue();
          Map<String, Value> embedded_map = DatastoreHelper.getPropertyMap(embedded_entity);
          String embedded_name = DatastoreHelper.getString(embedded_map.get("name"));
      }

    // And then just c.output whatever you need.

   }
}