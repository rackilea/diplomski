import static scala.collection.JavaConversions.asJavaCollection;
public class App {
    public List<Author> loadAuthorsFromFile(File file) {
        return new ArrayList<Author>(asJavaCollection(
            Author.loadAuthorsFromFile(file)));
    }
    public void sortAuthors(List<Author> authors) {
        Collections.sort(authors);
    }
    public void displaySortedAuthors(File file) {
        List<Author> authors = loadAuthorsFromFile(file);
        sortAuthors(authors);
        for (Author author : authors) {
            System.out.println(
                author.lastName() + ", " + author.firstName());
        }
    }
}