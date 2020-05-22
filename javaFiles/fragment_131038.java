while(true){
    levelCount = q.size();
    if(levelCount == 0) break;
    ArrayList<Integer> temp = new ArrayList<Integer>();
    while(levelCount > 0){
        TreeNode curr = q.poll();
        temp.add(curr.data);
        if(curr.left != null){
            q.add(curr.left);
        }
        if(curr.right != null){
            q.add(curr.right);
        }
        levelCount--;
    } // end of inner while 
    result.add(temp);
}