public String toString(){
    String stringVal = "[";
    if(root != null){
        stringVal+=getChildNoteString(root);
    }

    return stringVal+"]";
}

private String getChildNodeString(Node n){
    String nodeStringVal  = n+",";
    if(n.getLeft()!=null){
        nodeStringVal += ","+ getChildNodeString(n.getLeft());
    }

    if(n.getRight()!=null){
        nodeStringVal += ","+ getChildNodeString(n.getRight());
    }
}