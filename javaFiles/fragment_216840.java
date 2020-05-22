import java.util.*;
class BST
{
 Node root;
 LinkedList<Node> q=new LinkedList<Node>();
 TreeMap<Integer,Integer> level=new TreeMap<Integer,Integer>(); 
 TreeMap<Integer,Node> parent=new TreeMap<Integer,Node>(); 
 Node insert(Node x,int key)
 {
     if(x==null)
     {
         parent.put(key,null);
         return new Node(key,null,null,null);
     }
     else if(x.key<key)
     {
         x.right=insert(x.right,key);
         x.right.parent=x;
         if(parent.get(key)==null)
         parent.put(key,x);
         return x;
     }
     else if(x.key>key)
     {
         x.left=insert(x.left,key);         
         x.left.parent=x;
         if(parent.get(key)==null)
         parent.put(key,x);
         return x;
     }
     else { x.key=key; return x;}
 }
 public void BFS(Node r)
 {
     if(r==null)
      return;
     if(r.parent==null)
      level.put(r.key,0);
     else level.put(r.key,level.get(r.parent.key)+1);     
     q.add(r);

     while(q.size()!=0)
     {
        Node n=q.poll();
        BFS(n.left);
        BFS(n.right);
     }
 }
 public static void main(String []args)
 {
     BST tree1=new BST();
     tree1.root=null;
     tree1.root=tree1.insert(tree1.root,15);
     tree1.root=tree1.insert(tree1.root,66);
     tree1.root=tree1.insert(tree1.root,5);
     tree1.root=tree1.insert(tree1.root,3);
     tree1.root=tree1.insert(tree1.root,12);
     tree1.root=tree1.insert(tree1.root,75);
     tree1.root=tree1.insert(tree1.root,50);
     System.out.println(tree1.isCousins(66,75));
}
public boolean isCousins(int a,int b)
{
 BFS(root);
 if(level.get(a)==level.get(b)&&parent.get(a)!=parent.get(b))
  return true;
 else return false;
}
} 
class Node
{
 Node left,right,parent;
 int key;
 int level;
 Node(int k,Node l,Node r,Node p)
 {
     key=k;
     left=l;
     right=r;
     parent=p;
 }
}