List<Integer> solutions = new LinkedList<>();

Scanner systemScanner = new Scanner(System.in);
String line = null;

while ((line = systemScanner.nextLine()) != null && !line.isEmpty()) {
    Scanner lineScanner = new Scanner(line);
    int p = lineScanner.nextInt();
    int c = lineScanner.nextInt();
    int d = p + c;
    solutions.add(d);
}

Iterator<Integer> solution = solutions.iterator();
while (solution.hasNext()) {
    int u = solution.next();
    System.out.println(u);
}