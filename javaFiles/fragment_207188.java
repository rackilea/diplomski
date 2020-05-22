if (select > 0 && select <= 4){
    System.out.printf("You selected: item%d\n", select);
    System.out.printf("Plese enter the quantity sold for item%d: ", select);
    solds = input.nextInt(); //getting user input
    System.out.print("\n");
    a.GrossCal(select, solds);
} else if (select != 0) {
    System.err.print("Wrong selectiong, please try again...\n\n");
}