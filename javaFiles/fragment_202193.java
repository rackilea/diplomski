public String getEmpirestxt2(String fileName) {
    Charset charset = Charset.forName("ISO-8859-1");
    Path filePath = Paths.get(fileName);
    try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {
        String line = null;

        // find the start of the piece
        while ((line = reader.readLine()) != null && !line.equals(START)) {
        }
        System.out.println("START: " + line);

        // getting the piece
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null && !line.startsWith(END)) {
            sb.append(line);
        }
        System.out.println("END: " + line);

        return sb.toString();
    } catch (IOException x) {
        System.err.format("IOException: %s%n", x);
    }
    return null;
}