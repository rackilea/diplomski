DirectoryScanner scanner = new DirectoryScanner();
scanner.setIncludes(new String[]{"**/*.java"});
scanner.setBasedir("C:/Temp");
scanner.setCaseSensitive(false);
scanner.scan();
String[] files = scanner.getIncludedFiles();