TransformerFactory tf;
tf.setURIResolver(new SomeOtherResolver());
tf.setURIResolver(new MyResolver(tf.getURIResolver());

public class MyResolver implements URIResolver {
    public MyResolver(URIResolver nextInLine) {
        this.nextInLine = nextInLine;
    }
    private URIResolver nextInLine;
    public Source resolve(String href, String base) throws TransformerException {
        ...try to solve and return Source object...
        return nextInLine; // instead of returning null on failure, return nextInLine
    }
}