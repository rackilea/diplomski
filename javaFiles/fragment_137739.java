public static void readKnownWords() 

    // This is just the same as the previous example, except we
    // know in advance the number of lines we will be reading    
    File words = new File("Words.txt");

    BufferedReader reader = null;
    try {

        // Create the word array of a known quantity
        // The quantity value could be defined as a constant
        // ie public static final int WORD_COUNT = 10;
        String[] wordArray = new String[10];

        reader = new BufferedReader(new FileReader(words));
        // Instead of reading to a char buffer, we are
        // going to take the easy route and read each line
        // straight into a String
        String text = null;
        // The current array index
        int index = 0;
        // Read the file till we reach the end
        // ps- my file had lots more words, so I put a limit
        // in the loop to prevent index out of bounds exceptions
        while ((text = reader.readLine()) != null && index < 10) {

            wordArray[index] = text;
            index++;

        }

        System.out.println("Read " + wordArray.length + " words");

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            reader.close();
        } catch (Exception e) {
        }
    }

}