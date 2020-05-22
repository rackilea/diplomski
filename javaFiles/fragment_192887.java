String newLine;
try (PrintStream output = new PrintStream("fruits.out");
        BufferedReader br = new BufferedReader(new FileReader("fruits.in"))) {
    while ((newLine = br.readLine()) != null) {
        // reached an empty line
        if (newLine.isEmpty()) {
            output.println("orange");
            output.println("melon");
        }
        output.println(newLine);
    }
    // reached end of file
    output.println("orange");
    output.println("melon");
}