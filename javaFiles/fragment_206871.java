public static void main(String[] args) throws IOException {
    File file = new File("output.txt");
    Scanner scanner = new Scanner(file);

    ArrayList<shortestRoute> arrayList = new ArrayList<shortestRoute>();

    for(int i =0, n = scanner.nextInt(); i < n; i++) {
        arrayList.add(new shortestRoute(scanner.nextInt(), scanner.nextInt()));
    }
    scanner.close();

    System.out.println(arrayList);
}