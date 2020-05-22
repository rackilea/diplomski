public static void readUnknownWords() {

    // Reference to the words file
    File words = new File("Words.txt");
    // Use a StringBuilder to buffer the content as it's read from the file
    StringBuilder sb = new StringBuilder(128);

    BufferedReader reader = null;
    try {

        // Create the reader.  A File reader would be just as fine in this
        // example, but hay ;)
        reader = new BufferedReader(new FileReader(words));
        // The read buffer to use to read data into
        char[] buffer = new char[1024];
        int bytesRead = -1;
        // Read the file to we get to the end
        while ((bytesRead = reader.read(buffer)) != -1) {

            // Append the results to the string builder
            sb.append(buffer, 0, bytesRead);

        }

        // Split the string builder into individal words by the line break
        String[] wordArray = sb.toString().split("\n");

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