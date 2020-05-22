try (Scanner scanner = new Scanner(new FileInputStream("data"))) {
    while (scanner.hasNext()) {
        String line = scanner.nextLine().trim();
        set.add(line);
    }
} catch (FileNotFoundException e) {
    System.out.println("data is not found");
    e.printStackTrace();
}