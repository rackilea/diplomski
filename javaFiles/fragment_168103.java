int choice = 0;
for (;;) {
    while(!input.hasNextInt()) {
        System.out.println("Numbers Only!");
        System.out.print("Try again: ");
        input.nextLine();
    }
    choice = input.nextInt();
    if (choice <= diff.length) break;
    System.out.println("Out of bounds");
}
System.out.println(choice);