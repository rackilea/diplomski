public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    String name = getString(sc, "What is your name? ");
    int age = getInt(sc, "What is your age? ");
    System.out.println("Your name is " + name + " and your age is " + age);
}


/* You increase the performance when using an already existing single      
scanner multiple times for different reasons (to get a name, first name, 
second name, age, etc.), instead of making a new Scanner each time */

public static String getString(Scanner sc, String message) {
    System.out.print(message);
    return sc.nextLine();
}

public static int getInt(Scanner sc, String message) {
    System.out.print(message);
    if (sc.hasNextInt()) {
        return sc.nextInt();
    } else {
        sc.next(); // required to skip the current input
        return getInt(sc, "Please insert a number: ");
    }
}