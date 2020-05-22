List<Class<?>> exceptionTypes = new ArrayList<>();
exceptionTypes.add(IllegalArgumentException.class);
exceptionTypes.add(IOException.class);

try {
  // do something
} catch (Exception e) {
  if (exceptionTypes.contains(e.getClass())) {
    e.printStackTrace();
  }
}