while (lineScanner.hasNext()) {
        String word = lineScanner.next();
        if(!(word.equals("a")) && !(word.equals("an")) && !(word.equals("the"))) {
            writeFile.print(word + " ");
            System.out.print(word);
        }

    }