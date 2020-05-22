public static int liesInt() {
    int i;
    boolean has_input_int;
    boolean isValid_int = false;
    String input = "";

    Scanner keyboard = new Scanner(System.in); // Decl. & int. a scanner.
    do {
        System.out.print("Geben Sie eine Int Zahl ein! ");

        while (!keyboard.hasNextInt()) {
            System.out.println("Fehler! Falsche Eingabe Versuchen sie es 
nochmals!");
            keyboard.next();
        }
        i = keyboard.nextInt();
        isValid_int = true;
    } while (isValid_int == false);
    return i;
}