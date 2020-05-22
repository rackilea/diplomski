public static List<Integer> defaultStringToListInt(String s) {
    List<Integer> result = new ArrayList<>();
    Scanner scan = new Scanner(s);
    scan.useDelimiter(Pattern.compile("[, \\[\\]]+"));
    while (scan.hasNextInt())
        result.add(scan.nextInt());
    scan.close();
    return result;
}