articles.stream().map(Article::toString).forEach(str -> {
    try {
        w.write(str + System.lineSeparator()); // Add a newline to each string.
    } catch(IOException e) {
        ...
    }
});