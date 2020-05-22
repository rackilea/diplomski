File infile = new File("input.txt");
File outfile = new File("output.txt");
try (BufferedReader reader = Files.newBufferedReader(infile.toPath());
     BufferedWriter writer = Files.newBufferedWriter(outfile.toPath())) {
    String line;
    while ((line = reader.readLine()) != null) {
        String parts[] = line.split("/");
        String one = parts[0];
        String two = parts[1];
        writer.write(one + "/" + two);
    }
} catch (IOException ex) {
    System.err.println(ex.getLocalizedMessage());
}