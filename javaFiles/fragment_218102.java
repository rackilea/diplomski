List<String> lines = new ArrayList<>();
try (final Scanner scanner = new Scanner(is)) {
    while(scanner.hasNextLine()){
        lines.add(scanner.nextLine());
        //or handle that line here instead of storing it in list
    }
}