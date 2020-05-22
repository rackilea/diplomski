ArrayList<String> words = new ArrayList<>();
words.add("Cat");
words.add("Dog");
words.add("Bird");
words.add("Dog");
words.add("Cat");
words.add("Dog");

ArrayList<String> alreadyParsed = new ArrayList<>();
for (String word : words) {
    if (alreadyParsed.contains(word)) {
        continue;
    }

    int counter = 0;
    for (String candidate : words) {
        if (candidate.equals(word)) {
            counter++;
        }
    }

    System.out.println(word + " " + counter);
    alreadyParsed.add(word);
}