File file = new File("names.txt");
try (Scanner my_input = new Scanner(file)) {
    String[] anArray = new String[10];
    for (int i = 0; i < 10 && my_input.hasNextLine(); i++) {
        String line = my_input.nextLine();
        if (line.isEmpty()) {
            continue;
        }
        anArray[i] = line;
        System.out.printf("Element %d of the array is: %s%n", i, anArray[i]);
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}