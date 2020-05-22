String[][] alphabet = new String[26][45];

    try {
        // read the entire file into memory
        List<String> lines = Files.readAllLines(Paths.get("C://temp/xx.txt"));
        // this will hold 45x1 array as list
        List<String> concatenated = new ArrayList<>();
        int row = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                // convert list to array and add to matrix
                alphabet[row] = concatenated.toArray(alphabet[row]);
                concatenated = new ArrayList<>();
                row++;
            } else {
                // convert result of split() to list and add to letter list
                concatenated.addAll(Arrays.asList(line.split(" ")));
            }
        }
        // take care of last letter
        alphabet[row] = concatenated.toArray(alphabet[row]);
    } catch (IOException e) {
        e.printStackTrace();
    }
    Arrays.stream(alphabet).forEach(row -> System.out.println(Arrays.toString(row)));
}