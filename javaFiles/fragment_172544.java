Map<String, Set<String>> classesInPackage = new HashMap();
for (String entry : eachClasspathEntry()) {
  if (isClassFile(entry)) {
    String packageName = getPackageName(entry);
    if (!classesInPackage.containsKey(packageName)) {
      classesInPackage.put(packageName, new HashSet<String>());
    }
    classesInPackage.get(packageName).add(getClassName(entry));
  } else if (isJarOrZipFile(entry)) {
    // Do the same for each JAR/ZIP file entry...
  }
}
classesInPackage.get("com.foo.bar"); // => Set<String> of each class...