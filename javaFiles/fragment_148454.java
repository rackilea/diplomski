do {
    System.out.println("Current list is " + list);
    System.out.println("Add more? (y/n)");
    if (input.next().startsWith("y")) {
        System.out.println("Enter : ");
        list.add(input.next());
    } else if (input.next().startsWith("n")) {
        System.out.println("You have added the following:");
        break;
    } else {
        System.out.println("Error, you inputted something wrong");
    }
} while (true);