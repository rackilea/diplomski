public class Book implements Serializable {
    int ISPN;
    String title;
    String description;
    int pageCount;
    ArrayList<Integer> AuthorIds;
    Storage storage;

    public Book(Storage storage) {
        this.storage = storage;
    }

    public void addAuthor(Author author) {
        storage.addAuthor(author);
        AuthorIds.add(author.authorID);
    }

    public List<Author> createAuthorsList() {
        List<Author> authorList = new ArrayList<>();
        for (Integer authorId : AuthorIds) {
            authorList.add(storage.getAuthor(authorId));
        }
        return authorList;
    }
}