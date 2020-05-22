twitsRDD.mapPartitions(iter -> {
    Lemmatizer lemmatizer = new Lemmatizer();
    List<List<String>> lemmas = new LinkedList<>();

    while (iter.hasNext()) {
        lemmas.add(lemmatizer.Execute(iter.next()));
    }

    return lemmas.iterator();
});