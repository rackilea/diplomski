private static List<Object[]> readFile(String fileName) {
    List<Object[]> list = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        String[] splitLine;

        while ((line = br.readLine()) != null) {
            splitLine = line.split(";");
            // add an array, first element is the line itself, second element is the double value
            list.add(new Object[] {line, Double.valueOf(splitLine[1])});
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return list;
}