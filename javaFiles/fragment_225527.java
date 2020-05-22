Scanner stdin = new Scanner(new BufferedInputStream(System.in));
while (stdin.hasNext()) {
    String line = stdin.nextLine();
    for (String part : line.split("!")) {
        System.out.println(part);
    }
}