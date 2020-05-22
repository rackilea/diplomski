public void clearAllSelections(){
    //Recursively clear all the selections in the sub-tree of this node
    //basis:
    isSelected = false;
    if(isLeaf()) return;

    //recursion:
    if (childrenRight != null)
        childrenRight.clearAllSelections();
    if (childrenLeft != null)
        childrenLeft.clearAllSelections();

}