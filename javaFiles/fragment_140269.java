try (final Scanner scanner = new Scanner(new File("data.txt"))) {
    scanner.useDelimiter("\\s+");
    while (scanner.hasNextLine()) {
        final String key = scanner.next();
        final String value = scanner.next();
        map.put(key, value);
    }
}