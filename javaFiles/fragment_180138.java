Scanner scanner = new Scanner(System.in);

private String[] takeInput() {   
    String line = scanner.nextLine();
    String[] tokens = line.split(",");
    return tokens;
}