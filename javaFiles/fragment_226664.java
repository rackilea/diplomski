public boolean isLargest(Node tmp, Node parent){
if(tmp.value > parent.value){
    parent = parent.right;
    return tmp.isLargest(tmp, parent);
}
else if(parent.value == tmp.value){
    System.out.println("test");
    return true;
}       
return false;