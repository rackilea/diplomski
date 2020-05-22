recurseTree(Thing obj, String indent) {
    print(indent+obj.value);
    if (obj.children != null) {
       for (Thing child: obj.children) {
          recurseTree(child, indent+"   ");
       }
    }
}