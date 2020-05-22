public class Tree {

    List<Tree> child;

    public void removeChild(Tree tree) {
        child.remove(tree);
    }
}