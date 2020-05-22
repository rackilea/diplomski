public void fetchAllChildren(OnTimeNowRelease root, List<OnTimeNowRelease> childList){
    // if the parent is not defined, nothing to do
    if(root == null){
         return;
    }

    //add the parent to the list. Since java is Reference by Value, the list can be used for recursively adding all the descending elements 
    childList.add(root);
    if(root.children !=null && !root.children.isEmpty()){   
         for(OnTimeNowRelease children : root.children){
                //simple recursive solution add all the children and their children and so on....
                fetchAllChildren(root.children, childList);
         }
    }
}