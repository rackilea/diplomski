import apple.laf.JRSUIUtils;

    import java.util.ArrayList;
    import java.util.List;

    /**
     * Created by anilwaddi on 8/1/17.
     */
    public class DFSTest {


      public static void main(String args[]) throws Exception {

        DFSTest test = new DFSTest();
        test.printDFS();
    /*
    10 5 3 3
    10 5 3 -2
    10 5 2 1
    10 -3 11
     */
      }

      TreeNode root;

      DFSTest() {
        TreeNode node41 = new TreeNode(3, null, null);
        TreeNode node42 = new TreeNode(-2, null, null);
        TreeNode node43 = new TreeNode(1, null, null);


        TreeNode node31 = new TreeNode(3, node41, node42);
        TreeNode node32 = new TreeNode(2, node43, null);
        TreeNode node33 = new TreeNode(11, null, null);

        TreeNode node21 = new TreeNode(5, node31, node32);
        TreeNode node22 = new TreeNode(-3, node33, null);
        root = new TreeNode(10, node21, node22);
      }

      public void printDFS() {
        printPath(root);
      }

      public void printPath(TreeNode root) {
        printDFS(root, new ArrayList<Integer>());

      }

      private void printDFS(TreeNode r, List<Integer> path ) {
        if (r == null) return;

        path.add(r.val);

        /* if it's leaf, print path: from root to leaf */
        if (r.left == null && r.right == null)
          printOnePath(path );

        else {
            /* otherwise: go left, go right */
          List<Integer> newPathLeft = new ArrayList<>();
          newPathLeft.addAll(path);
          printDFS(r.left, newPathLeft);

          List<Integer> newPathRight = new ArrayList<>();
          newPathRight.addAll(path);
          printDFS(r.right, newPathRight);
        }
      }


      private void printOnePath(List<Integer> path ) {
        for (int i = 0; i < path.size(); i++) {
          System.out.print(path.get(i) + " ");
        }
        System.out.println();
      }

      private class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer val;

        TreeNode(Integer val) {
          this.val = val;
        }

        TreeNode(Integer val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
      }
    }