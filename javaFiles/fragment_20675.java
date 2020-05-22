for (int i = 0; i < words.length; ++i) {
        boolean gotMorse = false;
        for (int d = 0; d < MORSE.length; d++) {
            if (MORSE[d].equals(words[i])) {
                // code found.
                output += (char) ('A' + d);
                gotMorse = true;
                break;
            }
        }
        if (!gotMorse) {
            output += "?";
            // or System.out.print("?"); if you do not need ? in the output
        }

    }