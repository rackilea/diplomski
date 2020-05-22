public static String stringify(ArrayList<?> list) {
    String listString = "";
    for (int s=0, l=list.size(); s<l; s++) {
      listString += list.get(s).toString();
      if(s<l-1) { listString += ", "; }
    }
    return listString;
  }

  public static void main(String[] args) {
    // hard coded data based on your question-supplied example data
    Node.create(0, "A");
    Node.create(1, "B", 0);
    Node.create(2, "C", 0);
    Node.create(4, "D", 1);
    Node.create(5, "E", 1);
    Node.create(6, "F", 4);
    Node.create(3, "G", 0);

    // let's see what we get!
    Node root = Node.getNode(0);
    Node f = Node.getNode(6);
    System.out.println("From root to F: " + stringify(root.getDescendentPathTo(6)));
    System.out.println("From F to root: " + stringify(f.getAncestorPathTo(0)));
  }