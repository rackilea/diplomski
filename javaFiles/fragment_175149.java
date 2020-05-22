/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0) {
            return null;
        } else {
            return sub(num, 0, num.length-1);
        }
    }

    public TreeNode sub(int[] num, int start, int end) {
        int indexRoot = (start+end+1) / 2;
        TreeNode root = new TreeNode(num[indexRoot]);

        if(indexRoot > start) {
            root.left = sub(num, start, indexRoot-1);
        }
        if(indexRoot < end) {
            root.right = sub(num, indexRoot+1, end);
        }

        return root;
    }
}