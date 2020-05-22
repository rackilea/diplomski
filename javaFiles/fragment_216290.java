private static void dropLines(String[] args, String f) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(f), Charset.forName("UTF-8"));
    PrintWriter pw = new PrintWriter(new FileWriter(f));
    boolean empty = false;

    for (String string : lines) {
        if (!string.trim().startsWith("//#") && !string.trim().startsWith("//@")) {
            if (string.trim().equals("") && !empty) {
                pw.println(string);
                empty = true;
            } else if (!string.trim().equals("")) {
                pw.println(string);
                empty = false;
            }
        }
    }

    pw.flush();
    pw.close();
}