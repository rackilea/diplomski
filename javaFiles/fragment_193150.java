int kthSmallest(Node root , int k){
    //empty root, don't change counter
    if(root == null)
        return k;
    else {
         //update counter - equivalent to k -= root.left.size()
         k = kthSmallest(root.left, k);

         if(k == 0) //kth element
         {
             System.out.println(root.key);
             return -1; //return some invalid counter
         }

         //currently visited node
         k--;

         //search right subtree
         return kthSmallest(root.right, k); 
    }
}