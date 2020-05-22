input.nextLine();
while (input.hasNextInt()) {
    System.out.println("Found next int"); // used for debugging
    int i = input.nextInt();
    coinTypes.add(i);
    if (input.hasNextLine()) {
        change = input.nextInt();
        System.out.println("Found change"); // used for debugging
        System.out.println("Change: " + change);
    }
}