int compareResult = element.compareTo( node.element );
if ( compareResult < 0 ) { // recursive case - left
    node.leftChild = add( node, node.leftChild, element );
}
else if ( compareResult > 0 ) { // recursive case - right
    node.rightChild = add( node, node.rightChild, element );
}
else {
    throw new SearchTreeException( "Duplicate element: " + element.toString() );
}