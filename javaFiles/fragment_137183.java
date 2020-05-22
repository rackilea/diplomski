public final class Document {

    private final class AnonymousContentVisitor implements ContentVisitor {

        public void onStartDocument() {
            throw new IllegalStateException();
        }

        public void onEndDocument() {
            out.endDocument();
        }

        public void onEndTag() {
            out.endTag();
            inscopeNamespace.popContext();
            activeNamespaces = null;
        }
    }

    private final ContentVisitor visitor = new AnonymousContentVisitor();
}