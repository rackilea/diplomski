@XmlRootElement(name = "authors", namespace="http:www.../base")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorList {

    private List<AuthorMeta> author;

    public List<AuthorMeta> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorMeta> data) {
        this.author = data;
    }
}