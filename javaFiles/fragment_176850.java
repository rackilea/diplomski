public static void main(String[] arguments) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("data.txt"));
    List<Integer> integers = new ArrayList<Integer>();
    while (scanner.hasNext()) {
        int i = scanner.nextInt();
        if (i != 0)
            integers.add(i);
    }
    System.out.println(integers);
}