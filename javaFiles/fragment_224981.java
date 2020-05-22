//*** Pseudo-ish Code ***
class BSTNode 
{
    public BSTNode lChild;
    public BSTNode rChild;
    public int key;

    public BSTNode(int key) 
    {
        this.lChild = null;
        this.rChild = null;
        this.key = key;
    }

    /* Create INSERT function in BSTNode class so that you dont have to give the "CurrentNode" everytime
       you call this method, Now you just have to pass the "Key"*/
    public void insertValue(int insertValue)
    {
        if(insertValue < key)
        {
            if(lChild == null)
                lChild = new BSTNode(insertValue);
            else
                lChild.insertValue(insertValue);
        }
        else if(insertValue > key)
        {
            if(rChild == null)
                rChild = new BSTNode(insertValue);
            else
                rChild.insertValue(insertValue);
        }
        else;
    }
}

class BST 
{
    private BSTNode root;
    public BST() 
    {
        this.root = null;
    }

    // just create the root if not present else it'll call the recursive method of BSTNode class
    public void insert(int value)
    {
        if(root == null)
            root = new BSTNode(value);
        else
            root.insertValue(value);
    }

    // you didn't provide these methods so i wrote my own just to get your code runing 
    public BSTNode getRoot()
    {
        return root;
    }

    public int getRootValue()
    {
        return root.key;
    }
}

public class BSTMain
{
    public static void main(String[] args)
    {   
        BST testBST = new BST();
        testBST.insert(10);
        testBST.insert(7);

        System.out.print(testBST.getRootValue()); 
        System.out.print(" ");
        System.out.print(testBST.getRoot().lChild.key);
    }
}