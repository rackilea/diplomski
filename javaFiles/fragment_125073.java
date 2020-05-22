public String toString() {
    StringBuilder res = new StringBuilder();
    toStringRec(this, 0, res);
    return res.toString();
}


 public static void toStringRec(Node node, int depth, StringBuilder result){
    if(node==null)
        return;

    // adding self to result
    result.append("\n");
    for(int i=0; i<depth; i++)
        result.append("\t");
    result.append(node.val);

    for (Node sucessor : node.successors  ) {
      toStringRec(sucessor, depth+1, result);
    }
}