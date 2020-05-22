public static void main(String[] args) {

    String word = "";
    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter a word: " + word);
    word = keyboard.nextLine();

    boolean done = false;
    do{
        String readChar = null;
        System.out.print("What letter do you want to replace?: ");
        readChar = keyboard.next();

        if(word.contains(readChar)){

            String changeChar;
            System.out.print("With what letter do you wish to replace it? ");
            changeChar = keyboard.next();

            done = true;
            keyboard.close();
            System.out.println(word.replace(readChar, changeChar));
        }
    }
    while(!done);
}