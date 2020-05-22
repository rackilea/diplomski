public static void main (String... args) throws Exception {
    File file = new File("/path/to/your/file.txt");
    List<MyData> dataList = new ArrayList<>();

    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        MyData data = makeData(line);
        if(data != null) dataList.add(data);
    }
    scanner.close();
}