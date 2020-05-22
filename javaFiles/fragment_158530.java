public static void main(String[] args) {
    Bag obj = new Bag();
    int menu, choice = 0;

    Scanner input = new Scanner(System.in);
    do {
        //only print the menu once, you can use a do while for that
        System.out.println(" 1. Add item ");
        System.out.println(" 2. Remove item ");
        System.out.println(" 3. Display All");
        System.out.println(" 4. Exit ");
        menu = input.nextInt();

        switch (menu) {
        case 1:
            while (choice != 2) {
                System.out.println("What do you want to enter: ");
                obj.add(input.next()); //you call add with input.next as well if you want

                System.out.println("Enter another? 1: Yes, 2: No");
                choice = input.nextInt();
            }
            break;
        case 2:
            System.out.println("What do you want to remove: ");
            obj.remove(input.next()); //just call the remove method on Bag
            break;
        case 3: obj.display(); break; //call the display you already implemented!
        }

    } while (menu != 4);
}