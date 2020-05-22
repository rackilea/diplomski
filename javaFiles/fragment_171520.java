public class Comment {
    String author;
    String comment_body;
    Comment replies;

    @Override
    public String toString() {
        return "Comment{author='" + author + "', comment_body='" + comment_body + "', replies=" + replies + '}';
    }
}