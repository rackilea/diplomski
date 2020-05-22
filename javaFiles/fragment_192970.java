List<File> result = new ArrayList<>();
File dir = new File("/tmp");
File[] files = dir.listFiles();
if (files != null) {
    for (File f : files) {
        if (f.isFile()) {
            result.add(f);
        }
    }
}
System.out.println(result);