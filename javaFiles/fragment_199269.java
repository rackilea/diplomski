private static List<String> readFile(String fileName, List<String> inputLines) {
    try {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            // System.out.println(scanner.nextLine());
            inputLines.add(scanner.nextLine());
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return inputLines;
}