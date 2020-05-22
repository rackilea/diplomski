private static int methodCalls = 0; // Class Global Member Variable

public static String createSocial() {
    methodCalls++;
    Scanner sc = new Scanner(System.in);
    String social = sc.nextLine();
    System.out.println(social + "     SOCIAL");
    if (social.length() != 4) {
        System.out.println("You did not type 4 digits, try again");
        social = createSocial();
    }

    // returnResult will eventually will hold the 
    // valid result to return.
    String returnResult = social;

    //check non-integers      
    while (social.length() > 0) {
        System.out.println(social.charAt(0) + " <--- Method call: " + methodCalls);
        if (Character.isDigit(social.charAt(0)) == false) {
            System.out.println("You did not type your last 4 digits correctly, try again");
            social = createSocial();
        }
        social = social.substring(1);
    }
    methodCalls--;
    return returnResult;
}