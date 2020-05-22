public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter: ");
    String entry = keyboard.nextLine();
    keyboard.close();
    if (entry.length() == 0) {
        throw new Exception("Exception Found");
    }
    else {
        String reverse = reverse(entry);
        if (reverse.length() == 0) {
            throw new Exception("Exception Found");                
        }
        else {
            // Do your Code                
            System.out.println(reverse);
        }
    }
}

static String reverse(String text) {
    String reverseString = "";
    for (int i = text.length() - 1; i >= 0; i--) {
        reverseString += text.charAt(i);
    }
    return reverseString;
}