public class BSTNode
{
public String token;
public int count;

public BSTNode leftChild;
public BSTNode rightChild;


public static BSTNode copyTree(BSTNode input){
if(input == null){
return null;
}
else{
BSTNode node = new BSTNode();
node.token = input.token;
node.count = input.count;

node.leftChild = BSTNode.copyTree(input.leftChild);
node.rightChild = BSTNode.copyTree(input.rightChild);
return node;

}

}

public static void main(String args[]){
BSTNode root = new BSTNode();
root.token  = "root";
root.count = 1;

BSTNode leftChild  = new BSTNode();;
leftChild.token  = "left child";
leftChild.count = 2;

root.leftChild = leftChild;

BSTNode copy = copyTree(root);
System.out.println(copy.token);
System.out.println(copy.leftChild.token);

}
}