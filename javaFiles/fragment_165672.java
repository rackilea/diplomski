public static <T> T create(java.lang.Class<T> clazz) {
  String iName = clazz.getSimpleName();
  EClassif classif = FooPackage.eInstance.getEClassifier(iName);
  if (classif != null && classif instanceof EClass) {
    return clazz.cast(FooFactory.eInstance.create((EClass)classif));
  }
  return null; // or throw exception, clazz not found or stuff like that
}