String text = " to Polyxena. Achilles appears in the in the novel The Firebrand by Marion \n" +
        "the firebrand   14852520\n" +
        " fantasy novelist David Gemmell omic book hero Captain Marvel is endowed with the courage of Achilles, as well \n" +
        "captain marvel  403585\n" +
        " the city its central theme and \n" +
        "corfu   45462";
Scanner scanner = new Scanner(text);

List<String> lines = new ArrayList<>();
StringBuilder buffer = new StringBuilder();

while (scanner.hasNext()) {
    String line = scanner.nextLine();
    buffer.append(line);
    if (line.matches(".*\\d+$")) {
        lines.add(buffer.toString());
        buffer.setLength(0);
    }
}