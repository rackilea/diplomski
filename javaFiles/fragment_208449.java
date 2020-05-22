List<String> desiredContent = new ArrayList<>();
Scanner scanner = new Scanner(new File("/path/to/file.csv"));
while (scanner.hasNext()) {
    String line = scanner.nextLine();
    String[] contents = line.split(" ");
    desiredContent.add(contents[4]);
}