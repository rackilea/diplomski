Field[] fields = Constants.class.getDeclaredFields();
List<Field> staticFields = new ArrayList<>();
for(Field f:fields) {
  if (Modifier.isStatic(f)) {
    staticFields.add(f);
  }
}
for (int i = 0; i < staticFields.size(); i++) {
  for (int j = i + 1; j < staticFields.size(); j++) {
    if (staticFields.get(i).get(null).equals(staticFields.get(j).get(null))) {
      throw new AssertionFailedError(staticFields.get(i) + " equals " 
        + staticFields.get(j));
    } 
  }
}