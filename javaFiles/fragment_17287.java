public HashMap<String, String> getRequired(Class<?> c) {

HashMap<String, String> fieldMap = new HashMap<>();

Field[] fields = c.getDeclaredFields();
for (Field f : fields) {

  Annotation[] annotations = f.getAnnotationsByType(XmlElement.class);
  for (int i = 0; i < annotations.length; i++) {
    Annotation annotation = annotations[i];

    if (annotation instanceof XmlElement) {
      XmlElement theElement = (XmlElement) annotation;
      String name = f.getName();
      if (theElement.required()) {
        fieldMap.put(name, "true");
      } else {
        fieldMap.put(name, "false");
      }
    }
  }
}
return fieldMap;
}