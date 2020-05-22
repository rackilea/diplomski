final class OrcSchemas {
  private OrcSchemas() {}

  /**
   * Returns all schema names in a depth-first traversal of schema.
   *
   * <p>The given schema is represented as '<ROOT>'. Intermediate, unnamed schemas like
   * StructColumnVector and ListColumnVector are represented using their category, like:
   * 'parent::<STRUCT>::field'.
   *
   * <p>This method is useful because some Orc file methods like statistics return all column stats
   * in a single flat array. The single flat array is a depth-first traversal of all columns in a
   * schema, including intermediate columns like structs and lists.
   */
  static ImmutableList<String> flattenNames(TypeDescription schema) {
    if (schema.getChildren().isEmpty()) {
      return ImmutableList.of();
    }
    ArrayList<String> names = Lists.newArrayListWithExpectedSize(schema.getChildren().size());
    names.add("<ROOT>");
    mutateAddNamesDfs("", schema, names);
    return ImmutableList.copyOf(names);
  }

  private static void mutateAddNamesDfs(
      String parentName, TypeDescription schema, List<String> dfsNames) {
    String separator = "::";
    ImmutableList<String> schemaNames = getFieldNames(parentName, schema);
    ImmutableList<TypeDescription> children = getChildren(schema);
    for (int i = 0; i < children.size(); i++) {
      String name = schemaNames.get(i);
      dfsNames.add(name);
      TypeDescription childSchema = schema.getChildren().get(i);
      mutateAddNamesDfs(name + separator, childSchema, dfsNames);
    }
  }

  private static ImmutableList<TypeDescription> getChildren(TypeDescription schema) {
    return Optional.ofNullable(schema.getChildren())
        .map(ImmutableList::copyOf)
        .orElse(ImmutableList.of());
  }

  private static ImmutableList<String> getFieldNames(String parentName, TypeDescription schema) {
    final List<String> names;
    try {
      // For some reason, getFieldNames doesn't handle null.
      names = schema.getFieldNames();
    } catch (NullPointerException e) {
      // If there's no children, there's definitely no field names.
      if (schema.getChildren() == null) {
        return ImmutableList.of();
      }
      // There are children, so use the category since there's no names. This occurs with
      // structs and lists.
      return schema.getChildren().stream()
          .map(child -> parentName + "<" + child.getCategory() + ">")
          .collect(toImmutableList());
    }
    return names.stream().map(n -> parentName + n).collect(toImmutableList());
  }
}