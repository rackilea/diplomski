for (String sentence : parts) {

        List<String> wordsInCurrentSentence = new LinkedList<String>();

        for (String w : words) {
            if (sentence.contains(w)) {
                wordsInCurrentSentence.add(w);
            }
        }

        if (!wordsInCurrentSentence.isEmpty()) {
            String result = wordsInCurrentSentence.stream().collect(Collectors.joining(","));
            System.out.println(sentence.trim() + " //contains: " + result);
        }
    }