public String printTree(int level) {
    String S = "";

    // notice the change to '=='
    if (this == null)
        return S;        

    S += this.data + " (level:" + level + ") ";

    // notice the for loop
    if( this.children != null)
        for(Node child : this.children)
            S += child.printTree(level + 1);

    return S;
}