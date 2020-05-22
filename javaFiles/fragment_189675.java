public int height(Node root){
       if(root == null)return 0;
       return 1+Max(height(root.left),height(root.right));
    }

    heightDifference = (height(this.right) - height(this.left))