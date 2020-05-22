public interface Node {
    public int getId();
    public String getName();

    public void saveTo(SaveVisitor visitor);
}

public abstract class AbstractNode {
    public List<Node> children;

    //Getters
    public List<Node> getChildren() { return children; }

    public void addChild(Node node) {
        if (children == null) {
            children = new ArrayList<Node>();
        }

        children.add(node);
    }

    @Override
    public void saveTo(SaveVisitor visitor) {
        if (visitor != null) {
            visitor.setId(getId());
            visitor.setName(getName());

            if (children != null) {
                for (Node child: children) {
                    child.saveTo(visitor);
                }
            }
        }
    }
}


public class Book extends AbstractNode {

}

public class Title extends AbstractNode {

}

public class Chapter extends AbstractNode {

}

public class Section extends AbstractNode {

}

public class Article extends AbstractNode {

}