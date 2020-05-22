Set<String> lines = new TreeSet<>();
while (scanner.hasNextLine()) {
    line = scanner.nextLine();
    lines.add(line);
    counter++;
}

for (String fileLine : lines) {
    System.out.println(fileLine);
}