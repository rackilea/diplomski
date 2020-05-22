String fileName = "/path/to/your/file/textFile.txt";
String csvFileName = "/path/to/your/file/csvFile.csv";

try (BufferedReader br = new BufferedReader(new FileReader(fileName));
     Writer writer = new FileWriter(csvFileName)) {
    String line;
    while ((line = br.readLine()) != null) {
        writer.append(line.replaceAll("[|]", ","));
        writer.append("\n");
    }
} catch(Exception e) {
    e.printStackTrace();
}