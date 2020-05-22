Scanner scanner = new Scanner(System.in);
boolean exit = false;
do {

    System.out.print("CMD> ");
    String input = scanner.nextLine();
    if ("exit".equalsIgnoreCase(input)) {
        exit = true;
    } else if (input.toLowerCase().startsWith("start")) {
        doStart(input);
    } else if (input.toLowerCase().startsWith("step")) {
        doStep(input);
    }

} while (!exit);