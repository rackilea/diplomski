public static void readLines() {

    String file_path = "src/input.txt";
    ArrayList<String> lines = new ArrayList<>();

    try {
        try (Stream<String> stream = Files.lines(Paths.get(file_path))) {
            stream.forEach(lines::add);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    String[] everything = new String[lines.size()];

    for (int i = 0; i < lines.size(); i++) {
       everything[i] = lines.get(i);
    }
}