public static void MoToEng(String string2) {
        int x = 0;
        char space = ' ';
        for (int y = 1; y <= string2.length(); y++) {
            String match = null;
            if (y == string2.length()) {
                // Reached the end of the string
                match = string2.substring(x);
            } else if (string2.charAt(y) == ' ') {
                // Reached the end of the word
                match = string2.substring(x,y);
                x = y+1;
                if (x == string2.length()) {
                    x--;
                }
            }

            if (match != null) {
                for (int j = 0;j < morse.length;j++) {
                    if (morse[j].equals(match+" ")) {
                        System.out.println(alphabet[j] + " ");
                    }
                }
            }
        }
    }