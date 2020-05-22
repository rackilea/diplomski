Scanner scanner = new Scanner(new File("demo.txt"));
scanner.useDelimiter(",");

while (scanner.hasNextInt()) {
    System.out.println(scanner.nextInt());
}