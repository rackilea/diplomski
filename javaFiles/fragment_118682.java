boolean nn = false;
String cfc = "Channel name: ";
String cn = null;
do {
    System.out.println(cfc);
    cn = sc.nextLine();
    System.out.println("Your channel name, " + cn + ", are you sure you like this name? type yes or no.");
    yn = sc.nextLine().trim().toLowerCase();
    if (yn.equals("yes")) {
        nn = true;
    }
} while (!nn);