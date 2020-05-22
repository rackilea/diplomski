public TreeNode find(TreeNode cur,int val) {

        TreeNode result = null;
        if(cur.left != null)
            result = find(cur.left,val);


        if(cur.value == val)
            return cur;
        if(result ==null && cur.right != null)
            result = find(cur.right,val);

        return result;

    }