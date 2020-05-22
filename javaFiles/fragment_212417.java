public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int h = 0;
        TreeNode node = root;
        while(node != null){
            h++;
            node = node.left;
        }
        return count(h, root);
    }

    public int count(int h, TreeNode node){
        if(node == null){
            return 0;
        }
        int v = heightRight(node.left);
        if(v == h - 1){
            return  (1 << (h - 1)) + count(h - 1, node.right);
            //The left subtree is a perfect binary tree with height h - 1
            //So, we only need to look at the right subtree
        }else {
            return (1 << (h - 2)) + count(h - 1, node.left);
            //The right subtree is perfect binary tree with height h - 2
            //So, we only need to look at the left subtree
        }
    }

    public int heightRight(TreeNode node){
        if(node == null){
            return 0;
        }
        int result = 0;
        while(node != null){
            node = node.right;
            result++;
        }
        return result;
    }
}