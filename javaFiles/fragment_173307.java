public Book searchClass(String inputClass) {
    return bookStore.stream()
        .filter(book -> book.getClassification() != null)
        .filter(book -> book.getClassification().equalsIgnoreCase(inputClass))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("book not found"));
}