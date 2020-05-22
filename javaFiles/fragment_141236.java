try (BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"));
     FileWriter writer = new FileWriter("output.txt");
     BufferedWriter bw = new BufferedWriter(writer)) {
    String line;
    while ((line = br.readLine()) != null) {
        line = line.replaceAll("([^,]+),(.*)", "$2,$1\r\n");
        bw.write(line);
    }
}
catch (IOException e) {
    System.err.format("IOException: %s%n", e);
}