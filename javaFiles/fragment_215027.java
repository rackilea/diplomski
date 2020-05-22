public String[] getMultiLineInput(int inputLimit) {
    String[] input = Arrays.stream(scanner.nextLine().toUpperCase().split("\\s+"))
            .limit(inputLimit)
            .toArray(String[]::new);
    return input;
}