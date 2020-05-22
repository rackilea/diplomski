List<List<String>> sort = new ArrayList<>();
    Map<String, ArrayList<Integer>> res = new HashMap<>();

    // split by sentence
    for (String sentence : someText.split("[.?!]\\s*")) {
        sort.add(Arrays.asList(sentence.split("[ ,;:]+"))); //put each sentences in list
    }

    // put all word in a hashmap with 0 count initialized
    final int sentenceCount = sort.size();
    sort.stream().forEach(sentence -> sentence.stream().forEach(s -> res.put(s, new ArrayList<Integer>(Collections.nCopies(sentenceCount, 0)))));

    int index = 0;
    // count the occurrences of each word for each sentence.
    for (List<String> sentence: sort) {
        for (String s : sentence) {
            res.get(s).set(index, res.get(s).get(index) + 1);
        }
        index++;
    }