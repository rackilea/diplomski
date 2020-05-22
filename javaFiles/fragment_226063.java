public static String getMainClassName() {
  for (final Map.Entry<String, String> entry : System.getenv().entrySet())
    if (entry.getKey().startsWith("JAVA_MAIN_CLASS")) // like JAVA_MAIN_CLASS_13328
      return entry.getValue();
  throw new IllegalStateException("Cannot determine main class.");
}