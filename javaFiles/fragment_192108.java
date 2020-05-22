while (scanner.hasNext()) {
    String word = scanner.next();
    words.add(word);
}

if (words.contains(this.whatFind)) {
    matches++;
}