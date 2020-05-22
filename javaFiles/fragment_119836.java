Scanner scanner = new Scanner(System.in);
StringBuilder builder = new StringBuilder();
int tracker = 0;

while(scanner.hasNext()) {
    String next = scanner.next();
    builder.append(next);
    tracker += next.length();

    System.out.println("The last letter handled was "+ builder.chatAt(tracker - 1));
}