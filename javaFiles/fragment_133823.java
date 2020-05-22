public static void printSuperClass(Class<?> clazz) {
  if (clazz == null) return;

  Class<?> superclass = clazz.getSuperClass();
  System.out.println(clazz.getName() + " extends " + superclass.getName());
  printSuperClass(superclass);
}