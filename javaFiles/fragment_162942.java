ArrayList<MultiTreeNode<Person>> chain = new ArrayList<>();
Boolean is_pot = isParentOfTarget(root_node,target_person,chain);
if(is_pot){
 // ... A relation exist between root_node and target_person
 // Chain contains all parents of target_person excluding root_node
}
else{
 // ... Root_node and target_person exists in two different worlds
 // Chain is a blank slate
}