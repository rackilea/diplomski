public static void addRootTag(File xml) throws IOException {
    final List<String> lines = new ArrayList<>();;
    try (Scanner in = new Scanner(xml)) {
        while (in.hasNextLine())
            lines.add(in.nextLine());
    }

    try (PrintStream out = new PrintStream(xml)) {
        out.println("<root>");
        for (String line : lines) {
            // indentation, if you want
            out.print("    ");
            out.println(line);
        }
        out.println("</root>");
    }
}