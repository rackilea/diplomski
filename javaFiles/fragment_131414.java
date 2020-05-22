StringBuilder result = new StringBuilder("");

//Get file from resources folder

ClassLoader classLoader = getClass().getClassLoader();
File file = new File(classLoader.getResource("fileName").getFile());

try (Scanner scanner = new Scanner(file)) {

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        result.append(line).append("\n");
    }

    scanner.close();

} catch (IOException e) {
    e.printStackTrace();
}