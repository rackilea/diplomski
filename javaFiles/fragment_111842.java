List<String> list = new ArrayList<>();
Scanner scanner = new Scanner(System.in);
String line;
while (!(line = scanner.nextLine()).equals("")) {
    list.add(line);
}
list.forEach(s -> System.out.println(s));