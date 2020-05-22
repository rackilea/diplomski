try {

        String originalWord = "alabalaportocalaORANGEalabalaportocalaORANGEalabalaportocalaORANGEalabalaportocalaORANGEalabalaORANGEORANGEaaaaaaa";
        String replacedWord = "ORANGE";
        String replacingWord = "APPLE";
        String substringedWord = "";

        // make sure this is smaller or equal with the number of occurrences, otherwise it's endless loop times
        int numberOfReplaces = 3;
        Random ran = new Random();
        int beginIndex;

        while (numberOfReplaces > 0) {
            // random index between 0 and originalWord.length()-1-replacedWord.length()
            beginIndex = ran.nextInt(originalWord.length()-1-replacedWord.length());
            substringedWord = originalWord.substring(beginIndex);
            if (substringedWord.contains(replacedWord)) {
                originalWord = originalWord.substring(0, beginIndex) + substringedWord.replaceFirst(replacedWord, replacingWord);
                numberOfReplaces--;                 
            }
        }
        System.out.println(originalWord);
    } catch (Exception exc) {
        System.err.println("An error occurred: \n" + exc);
    }