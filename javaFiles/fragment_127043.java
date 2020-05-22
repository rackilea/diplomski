import java.util.ArrayList;
import java.util.List;

class Tree{
    private List<Tree> childTree;
    private String name;

    public Tree(String name) {
        this.name = name;
    }

    public List<Tree> getChildTree() {
        return childTree;
    }

    public void setChildTree(List<Tree> childTree) {
        this.childTree = childTree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class TestDrive {

    public static void main(String arr[]){

        //Storing the values
        Tree a1 = new Tree("A1");

        Tree v1 = new Tree("v1");
        Tree v2 = new Tree("v2");

        List<Tree> a1Child = new  ArrayList<Tree>();
        a1Child.add(v1);
        a1Child.add(v2);

        a1.setChildTree(a1Child);

        Tree av1 = new Tree("av1");
        Tree av2 = new Tree("av2");

        List<Tree> v1Child = new  ArrayList<Tree>();
        v1Child.add(av1);
        v1Child.add(av2);

        v1.setChildTree(v1Child);

        Tree n1 = new Tree("n1");
        Tree n2 = new Tree("n2");

        List<Tree> av1Child = new  ArrayList<Tree>();
        av1Child.add(n1);
        av1Child.add(n2);

        av1.setChildTree(av1Child);

        Tree n11 = new Tree("n1");
        Tree n22 = new Tree("n2");
        List<Tree> av2Child = new  ArrayList<Tree>();
        av2Child.add(n11);
        av2Child.add(n22);

        av2.setChildTree(av2Child);

        //Retrieving the values

        printValue(a1,"");

    }

    private static void printValue(Tree tree,String treeName) {
        treeName = treeName+" : "+tree.getName();

        if(tree.getChildTree()!=null){
            List<Tree> childTreeList = tree.getChildTree();
            for (Tree childTree : childTreeList) {
                printValue(childTree,treeName);
            }
        }else{
            System.out.println(treeName);
        }
    }

}