for(int i = 0; i < in.length -1; i++){
    if(in[i].equals(base.element)){    // * Get the index of the root
        indexOfRoot = i; // in the inorder traversal.
        break;
    } // * If we cannot, the tree cannot be constructed as the traversals differ.
    else throw new IllegalArgumentException();
}