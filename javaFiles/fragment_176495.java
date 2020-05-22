public class Tree<I, A> {
    private final HashMap<I, Node<I, A>> map = new HashMap<>();
    private final Node<I, A> root;

    public Tree(I id, A value) {
        root = new Node<>(id, value);
        map.put(id, root);
    }

    public void addChild(I parentId, I id, A value) {
        Node<I, A> parent = map.get(parentId);
        Node<I, A> child = new Node<>(id, value);
        parent.children.add(child);
        map.put(id, child);
    }

    public A getById(I id) {
        return map.get(id).value;
    }

    public String subtreeToString(I id) {
        return map.get(id).toString();
    }

    private static class Node<I, A> {
        private final I id;
        private final A value;
        private final ArrayList<Node<I, A>> children = new ArrayList<>();

        private Node(I id, A value) {
            this.id = id;
            this.value = value;
        }

        private void print(int depth, PrintWriter pw) {
            for (int i = 0; i < depth; i++) {
                pw.print("\t");
            }
            pw.println("[" + id + ", " + value + "]");
            for (Node<I, A> child : children) {
                child.print(depth + 1, pw);
            }
        }

        @Override
        public String toString() {
            StringWriter writer = new StringWriter();
            print(0, new PrintWriter(writer));
            return writer.toString();
        }
    }
}