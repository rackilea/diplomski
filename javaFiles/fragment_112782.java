public static String readFromStandardIO() {

    String returnValue = "";

    System.out.println("Reading Strings from console");

    // You use System.in to get the Strings entered in console by user
    try {
        // You need to create BufferedReader which has System.in to get user
        // input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("Enter text...\n");
        while (true) {
            userInput = reader.readLine();
            System.out.println("Finally got in here");
            System.out.println(userInput);
            returnValue += userInput;
            if (!userInput.equals(userInput.trim())) {
                break;
            }
        }

        System.out.println("You entered : " + returnValue);

    } catch (Exception e) {

    }
    return returnValue;

}