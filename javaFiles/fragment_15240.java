public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a string");
    String s = input.nextLine();// methods should be called with () even if have no argument

    String lower = "";
    String total = "";

    for (int i = 0; i < s.length(); i++) {
        char thisChar = s.charAt(i);
        // you can replace with : if (Character.isLowerCase(thisChar))
        if (thisChar >= 97 && thisChar <= 122) {
            lower += thisChar;
        }
    }//close the for loop here

    System.out.println("Total amount of characters: " + s.length() + " - " + s);
    System.out.println("Lower case letters: " + lower.length() + " - " + lower);
}