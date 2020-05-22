StringBuilder sb = new StringBuilder();
while (scanner.hasNextLine()) {
    String line = scanner.nextLine().trim();
    if (line.isEmpty()) continue;
    sb.append(line).append(System.lineSeparator());
}
System.out.print(sb.toString());