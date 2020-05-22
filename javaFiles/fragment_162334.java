public static void main(String[] args) {
    Path filepath = Paths.get("./data.csv");
    CSVReader reader = new CSVReader(filepath);
    for (CSVRow row : reader) {
        for (String str : row) {
                System.out.printf("%s ", str);
        }
        System.out.println();
    }
}