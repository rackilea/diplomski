public void testStudent() throws IllegalArgumentException, IllegalAccessException {
    StudentTable student = new StudentTable();
    student.setColumnName1("Student 1 Name");
    String columnValue = null;
    Field[] fields = org.apache.commons.lang3.reflect.FieldUtils.getAllFields(StudentTable.class);
    for(Field f : fields) {
      Column columnAnnotation = f.getAnnotation(Column.class);
      if(columnAnnotation != null && StringUtils.equals(columnAnnotation.name(), "column_name1")) {
        f.setAccessible(true);
        columnValue = (String) f.get(student);
      }
    }
    System.out.println(columnValue);
  }