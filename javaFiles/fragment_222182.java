public class LeafSearching {

    private final Class typeToFind;

    private Object result;

    public LeafSearching(Class typeToFind) {
        this.typeToFind = typeToFind;
    }

    public void visit(Node node) {
        if (typeToFind.isAssignableFrom(node.getClass())){
            result = node;
            return;
        }

        for (Node child : node.getChildren()) {
            child.accept(this);
        }
    }
}

interface Node {

    boolean hasChildren();

    List<Node> getChildren();

    void accept(LeafSearching ls);
}

class Apple implements Node {
    //...
}

class Cat implements Node {
    // ...
}

class TreeRoot implements Node {

    private Apple apple;

    private Cat cat;

    public Apple getApple() {
        return apple;
    }

    public Cat getCat() {
        return cat;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public List<Node> getChildren() {
        final List<Node> children = new ArrayList<Node>;

        if (getApple() != null) {
            children.add(this.apple);
        }

        if (getCat() != null) {
            children.add(this.cat);
        }

        return children;
    }

    public void accept(LeafSearching ls) {
        ls.visit(this);
    }
}