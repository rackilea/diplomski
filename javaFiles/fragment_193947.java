List<String> list = new ArrayList<>();
// ...
File file = new File(dir.getAbsolutePath(), "SavedJavaArithmetic.txt");
try (PrintWriter pw = new PrintWriter(file)) {
    for (String str : list) {
        pw.println(str);
    }
}