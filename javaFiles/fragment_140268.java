try (final Scanner scanner = new Scanner(new File("data.txt"))) {
    while (scanner.hasNextLine()) {
        final String line = scanner.nextLine();
        final String[] parts = line.split("\\s+");
        map.put(parts[0], parts[1]);
    }
}