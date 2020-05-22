public TreeNode merge(TreeNode t) {
        TreeNode curr = this.root; 
        merge2(curr,t);
        return curr;
   }
   public  void merge2(TreeNode t1,TreeNode t2) {
        if(t2==null)
            return;
        t1.data += t2.data;
        if(t2.left!=null)
        {
            if(t1.left==null)
                t1.left = new TreeNode(0);
            merge2(t1.left,t2.left);
        }
        if(t2.right!=null)
        {
            if(t1.right==null)
                t1.right = new TreeNode(0);
            merge2(t1.right,t2.right);
        }

   }