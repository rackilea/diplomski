Scanner scan = new Scanner(System.in);
while (scan.hasNextLine()) {
    String line = scan.nextLine();
    String[] tokens = line.split("\\s+");
    String command = tokens[0];
    List<Integer> ints = Stream.of(tokens).skip(1)
            .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    System.out.printf("command = %s, ints = %s%n", command, ints.toString());
}