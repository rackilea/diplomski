boolean hasAuthor(String name) {
    for (Author author : authors) {
        if (author.name.equals(name)) {
            return true;
        }
    }
    return false;
}