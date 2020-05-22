File file = new File("test.txt");
try (Scanner scanner = new Scanner(file)) {
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        // ...
    }
} catch (IOException e) {
    e.printStackTrace();
}