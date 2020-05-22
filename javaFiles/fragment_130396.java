public ArrayList<String> buildListOfPaths(Node tree) {
    ArrayList<String> list = new ArrayList<String>();
    String str = "";
    traverse(tree, list, str);
    return list;
}

// The idea on how to iterate the elements comes from:
// https://stackoverflow.com/a/19338057
public void traverse(Node root, ArrayList<String> list, String str){ 
    // we know it's a leaf so we can add this path to the list
    if (root.getChildren() == null) {
        list.add(str + root.name);
        return;
    } else {
        for(Node each : root.getChildren()){
            traverse(each, list, str + each.name);
        }
    }
}