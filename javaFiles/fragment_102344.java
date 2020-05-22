import java.util.Collection;
import java.util.ArrayList;

interface Consumer<T> {
    void accept(T e);
}
// In Java 8, this interface is already part of the JRE.
// Just replace the 3 lines above with this import:
//import java.util.function.Consumer;

class Tree<T> {
    private String nodeName;
    private Collection<Tree<T>> children = new ArrayList<>();

    Tree(String name, Collection<Tree<T>> children) {
        nodeName = name;
        this.children = children;
    }

    Tree(String name) {
        nodeName = name;
    }

    public String getNodeName() { return nodeName; }
    public void setNodeName(String name) { nodeName = name; }

    public Collection<Tree<T>> getChildren() { return children; }
    public void setChildren(Collection<Tree<T>> children) { this.children = children; }

    void visitAll(Consumer<Tree<T>> block) {
        visit(block);
        for (Tree<T> tree : children) tree.visitAll(block);
    }

    void visit(Consumer<Tree<T>> block) {
        block.accept(this);
    }

    public static void main(String... args) {
        ArrayList<Tree<String>> children = new ArrayList<>();
        children.add(new Tree<String>("Reia"));
        children.add(new Tree<String>("MacRuby"));
        Tree<String> rubyTree = new Tree<>("Ruby", children);

        System.out.println("Visiting a node");
        rubyTree.visit(new Consumer<Tree<String>>() {
            public void accept(Tree<String> node) {
                System.out.println(node.getNodeName());
            }
        });
        // In Java 8, you can use a lambda.
        // Just replace the 5 lines above with this line:
        //rubyTree.visit(node -> System.out.println(node.getNodeName()));

        System.out.println();

        System.out.println("Visiting entire tree");
        rubyTree.visitAll(new Consumer<Tree<String>>() {
            public void accept(Tree<String> node) {
                System.out.println(node.getNodeName());
            }
        });
        // In Java 8, you can use a lambda.
        // Just replace the 5 lines above with this line:
        //rubyTree.visitAll(node -> System.out.println(node.getNodeName()));
    }
}