public static void main(String[]args) {
    // [...]
    Scanner s = new Scanner(System.in);
    String myString = s.nextLine();
    determineInputType(myString);
    // [...]
    s.close();
}

public static void determineInputType(String str) {
    // [...]
    Scanner s1 = new Scanner(System.in);
    // [...]

    /* This will affect the 's' Scanner from the 'main' method too
     * as it closes System.in, which is being used from 's' too
     */
    s1.close(); 

}