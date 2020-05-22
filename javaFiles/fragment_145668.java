String fileName = "/path/to/your/file/textFile.txt";
String csvFileName = "/path/to/your/file/csvFile.csv";

try (BufferedReader br = new BufferedReader(new FileReader(fileName));
     Writer writer = new FileWriter(csvFileName)) {
    String line;
    while ((line = br.readLine()) != null) {
        String csvLine = Arrays.stream(line.split("[|]")) // split on pipes
            .map(token -> token.contains(",") ? "\""+token+"\"" : token) // surround with double quotes if there is a comma in the value
            .collect(Collectors.joining(",", "", "\n")); // join with commas
        writer.append(csvLine);
    }
} catch(Exception e) {
    e.printStackTrace();
}