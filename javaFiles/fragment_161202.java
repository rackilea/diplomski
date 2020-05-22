public static List<Integer> stringToListInt(String s) {
    List<Integer> result = new ArrayList<>();
    Scanner scan = new Scanner(s);
    while (scan.hasNextInt())
        result.add(scan.nextInt());
    scan.close();
    return result;
}