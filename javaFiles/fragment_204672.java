//Root is 50 [42, 63]

     if(currentNode == root){
        root = successor;

     //Root is 55 [null, null]
     }else if(isLeftChld){
        parent.leftChild = successor;

     }else{
        parent.rightChild = successor;
     }

     //Root is 55 [42, null]
     root.leftChild = currentNode.leftChild;