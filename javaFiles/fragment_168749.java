int indexOfRoot = -1; //an impossible value
for(int i = 0; i < in.length -1; i++){
    if(in[i].equals(base.element)){    // * Get the index of the root
        indexOfRoot = i; // in the inorder traversal.
        break;
    } 
} 
if(indexOfRoot == -1){//if the root was never set
    throw new IllegalArgumentException();
}