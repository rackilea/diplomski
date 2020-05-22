HashSet<String> result = new HashSet();
for( Node leaf: list)
   search(false, name, leaf, result);


public void search(boolean found, String name, Node node, HashSet<String> result){
    if(node == null)
       return;
    found = found ? found : node.getName().equals(name);
    if(found)
       result.add(node.getId());

    search(found, name, node.getParent(), result);
}