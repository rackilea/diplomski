if(n.left!=null)
           n.left = del_leaves(n.left,k);
       if(n.right!=null)
           n.right = del_leaves(n.right,k);
       if(n.left ==null && n.right==null && n.k==k){
           return null;
       }
       return n;