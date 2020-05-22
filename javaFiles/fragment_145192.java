HashMap<String, String> dataCheck = new HashMap<String, String>();
    dataCheck.put("Flag1", "Additional Income");
    dataCheck.put("Flag2", "Be your own boss");
    dataCheck.put("Flag3", "Compete for your business");

    String paragraph = "When you have an additional Income, you can be your own boss. So advertise with us and compete for your business. We help you get additional income";

    // Now, iterate through each entry in the Map
    for (Map.Entry<String, String> entry : dataCheck.entrySet()) {

        // Keep track of the number of occurrences
        int count = 0;

        // After finding a match, we need to increase our index in the loop so it moves on to the next match
        int startingIndex = 0;

        // This will convert the strings to upper case (so our matches are case insensitive
        // It will continue looping until we get an an indexOf == -1 (which means no match was found)
        while ((startingIndex = paragraph.toUpperCase().indexOf(entry.getValue().toUpperCase(), startingIndex)) != -1) {

            // Add to our count
            count++;

            // Move our index position forward for the next loop
            startingIndex++;
        }

        // Finally, print out the total count per Flag
        System.out.println(entry.getKey() + ": " + count);
    }