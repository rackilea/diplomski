Scanner scanner = new Scanner(System.in);
String[] names = {"John", "Nico", "Sarah", "Pablo", "Micheal", ""};
System.out.print("Write your name: ");
String userName = scanner.nextLine();
names[names.length - 1] = userName;
System.out.println(Arrays
        .stream(names)
        .sorted()
        .collect(Collectors.joining(",")));