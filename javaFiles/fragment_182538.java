public class CommentSubject {

    private final Integer line;
    private final String path;
    private final String comment;

    public String path() { return path; }
    public Integer line() { return line; }
    public Comment comment() { return comment; }

    public static CommentSubject forFile(String p, String c) {
        return new CommentSubject(p, null, c);
    }
    public static CommentSubject forLine(String p, int i, String c) {
        return new CommentSubject(p, i, c);
    }

    private CommentSubject(String p, Integer i, String c) {
        path = p;
        line = i;
        comment = c;
    }
}