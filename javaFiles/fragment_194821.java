for (int i = 0; i < counter; i++) { // A loop to control the Array
        String[] words = football_list[i].split(":"); // Splits the input
                                                        // into 4 strings
        if (Main.validateString(football_list[i])) {
            System.out.println(words[0].trim() + " [" + words[2].trim() + "]" + " | " + words[1].trim() + " ["
                    + words[3].trim() + "]"); // Formats and prints the output
        }
        else{
            System.out.println("Your input of " + football_list[i] + " was not valid.");
        }
    }