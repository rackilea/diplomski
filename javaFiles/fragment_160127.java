for (Field field : entity.getClass().getDeclaredFields()) {
   Column column = field.getAnnotation(Column.class);
   if (column != null) {
      columnNames.add(column.name());
   }
}