String input = "Student @ Codey @ Huntting\r\n" +
               "Student @ Sarah @ Honsinger\r\n";
try (Scanner scanner = new Scanner(input).useDelimiter("[@\\v]")) {
    for (int tokenNum = 0; scanner.hasNext(); tokenNum++) {
        System.out.println("Token #" + tokenNum + ": \"" + scanner.next() + "\"");
    }
}