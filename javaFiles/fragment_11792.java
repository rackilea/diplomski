public static void main(String[] args) throws Exception {
    Scanner userInput = new Scanner(System.in);
    int maxArrayLength[] = { 1, 2, 3, 4, 5 };
    String words[] = new String[maxArrayLength.length];
    for (int i = 0; i < words.length; i++) {
        System.out.println("Please enter element " + maxArrayLength[i] + ":");
            words[i] = userInput.nextLine();
        }

    for(int lengthCheckCounter = 0; lengthCheckCounter < words.length; lengthCheckCounter++)
        if(words[lengthCheckCounter].length() > 4)
            System.out.println(words[lengthCheckCounter] + "-" + words[lengthCheckCounter].length());
        userInput.close();
}