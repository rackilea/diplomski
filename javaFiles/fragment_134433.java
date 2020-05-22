// Now pull only letters or numbers until we hit a space
        while (!Character.isWhitespace(next)) {
            if (Character.isLetterOrDigit(next)) {
                nextWord += myFile.charAt(position);
            }
            position++;
            next = myFile.charAt(position);
        }
        words[i] = nextWord;
        i++;