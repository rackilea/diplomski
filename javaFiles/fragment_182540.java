interface CommentProcessor {
    void onFileComment(String path, String comment);
    void onLineComment(String path, int line, String comment);
}
public class CommentSubject {

    private final Integer line;
    private final String path;
    private final String comment;

    public void process(CommentProcessor p) {
        if (line != null) {
            p.onLineComment(path, line.intValue(), comment);
        } else {
            p.onFileComment(path, comment);
        }
    }

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