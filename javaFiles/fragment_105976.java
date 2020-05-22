@ManyToMany(cascade = CascadeType.ALL)
private final Set<Author> authors = new HashSet<>();
// ...
public void setAuthors(Set<Author> authors) {
    for (Author author : authors) {
        author.getBooks().add(this);
        this.authors.add(author);
    }
}