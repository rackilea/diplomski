public Book search(String title) {
    for (int i = 0; i < this.Volume; i++) {
        if (title.equals(this.storage[i].toString())) {
            System.out.println("The book with the title " + title + " exists in the library!");
            return this.storage[i];
        }
    }
    System.out.println("The book with the title " + title + " does not exist in the library!");
    return null;
}