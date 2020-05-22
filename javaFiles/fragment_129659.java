if ( p instanceof LeafNode || p instanceof Node){
    System.out.println(p.guide);
} else if (p instanceof InternalNode) {
    InternalNode internalNode = (InternalNode) p;
     if (internalNode.child2 == null){
         printAll(internalNode.child0);
         printAll(internalNode.child1);
     } else {
         printAll(internalNode.child0);
         printAll(internalNode.child1);
         printAll(internalNode.child2);
     }
}