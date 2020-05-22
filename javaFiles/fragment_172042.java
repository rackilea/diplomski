public class TreeNode<T> implements Comparable {

 public T data;
 public double costs;
 public List<TreeNode<T>> children;

 // Bunch of getters and setters

 public int compareTo(TreeNode that) { return (int)(this.cost - that.cost); }
 }