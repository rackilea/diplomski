public static void main(String[] args){
        // boolean empty = false;           // --> not needed
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.nextLine();
        final int wordCount = getWordCount(str);

        if (wordCount > 0) { // show message only if there is at least one word
            System.out.println("Your string has " + wordCount +" words in it.");
            System.out.println("The first word is: " + firstWord(str));
        }
    }

    public static String firstWord(String input) {
        // .. code omitted for brevity
    }

    public static int getWordCount(String str){
        int count = 0;

        if(str != null && str.length() == 0){
            System.out.println("ERROR - string must not be empty.");
            // empty = true; -->  not needed
        }

        // ... code omitted for brevity
        return count;
    }