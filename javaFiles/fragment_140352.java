public static void main(String[] args) {

    Scanner in3 = new Scanner(System.in);
    System.out.print("Enter a sentence with capitals: ");
    String inputString = in3.nextLine();

    int stringLength = inputString.length();

    for (int i = 0; i < stringLength; i++)
    {
        char letterToCheck = inputString.charAt(i);

        if (Character.isUpperCase(letterToCheck)) 
        {
            System.out.println(letterToCheck);
        }

    }
    // in3.close(); // not really needed for System.in
}