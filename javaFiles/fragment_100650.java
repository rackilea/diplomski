public static List<String> readLinesFromFile() {
    List<String> lines = new ArrayList<String>();
    try {
        Scanner scanner = new Scanner(new File("upload.txt"));
        if (scanner.hasNext()){
            lines.add(scanner.nextLine());
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return lines;
}