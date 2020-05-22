public static void main(String[] args) throws Exception {

    int[] wordArray;
    String messageWord;
    char messageChar;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your message: ");
    messageWord = scanner.nextLine(); // read once before entering loop

    while (!messageWord.equals("exit")) { // notice the correct condition

        // these two variables should be reset for each word
        int y = 0;
        // and each messageArray should be of the right size            
        int[] messageArray = new int[messageWord.length()];

        for (int i = 0; i < messageWord.length(); i++) {
            messageChar = messageWord.charAt(i);
            // *** insert all those if conditions here ***
            y++;
        }

        // this goes inside the main loop
        for (int j = 0; j < messageArray.length; j++)
            System.out.print(messageArray[j] + " ");

        // we have to ask for the next word inside the main loop
        System.out.print("\nEnter your message: ");
        messageWord = scanner.nextLine();

    }

}