label = DynamicLabel.label("Label");
Iterable<IndexDefinition> indexes = schema.getIndexes(label);
for(IndexDefinition index : indexes) {
    for (String key: index.getPropertyKeys()) {
         if (key.equals("id")) {
              return true; // index for label and property exists
         }
    }
}
return false; // no matching schema index