String content="hello\n good day\n good bye";
File file = new File("output1.txt");
try (PrintWriter out = new PrintWriter(new FileOutputStream(
        file, false), true)) {
    for (String line : content.split("\\n\\s*")) {
        out.println(line);
    }
}