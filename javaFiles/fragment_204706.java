char[] parse = {' '};
        String delims = new String(parse);
        String line = null;
        while ((line = in.readLine()) != null) {

            String[] lineWords = line.split(delims);

                // split the words and create word object
            for (int i = 0; i < lineWords.length; i++) {
                Word w = new Word(lineWords[i]);
                words.add(w);
            }
            lineNum++;    // pass the next line

        }