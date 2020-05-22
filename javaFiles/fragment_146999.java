private void printFileContents() throws IOException {
    Path encoding = Paths.get("unicode.txt");

    try (Stream<String> stream = Files.lines(encoding)) {
        stream.forEach(v -> 
        {
            String output = "";

            // Takes unicode digits and converts to HEX value
            int parse = Integer.parseInt(v, 16);

            // Get the actual value of the hex value
            output += (char) parse; 

            System.out.println(output);
        });

    } catch (IOException e) {
        e.printStackTrace();
    }
}