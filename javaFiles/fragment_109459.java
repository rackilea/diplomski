while (in.hasNextLine()) {
    String line = in.nextLine();
    words = line.split(" ");

    //here so it can use the split from the previous line
    for (String word : words) {
        if (!record.containsKey(word)) {
            record.put(word, 1);
        }
        else {
            record.put(word, record.get(word) + 1);
        }
    }
}