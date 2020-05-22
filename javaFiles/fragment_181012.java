List<Integer> list = new ArrayList<>();
Scanner scanner = new Scanner(System.in);

do {
    System.out.println("Enter a number");
    String next = scanner.next();
    if (next.equals("c")) {
        break;
    }

    try {
        int number = Integer.parseInt(next);
        list.add(number);
        System.out.println(list);
    } catch (NumberFormatException ex) {
        System.out.println("That's not a number !");
    }
} while (true);