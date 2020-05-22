public static void modifyfruit() {
        System.out.println("Select what position to change");
        int option = chris.nextInt();
        System.out.println("Select A new fruit to add");
        String fruits = chris.next();
        charles.set(option + 1, fruits);
        System.out.println("Your new fruit is " + fruits);
        printlist();
    }