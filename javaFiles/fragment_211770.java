public FamilyNode findNodeByName(String nodeName){
   System.out.println("Visiting node "+ name);
   // That's not me that you are looking for, let's see my kids
   for(FamilyNode child : children){
     child.findNodeByName(nodeName)
   }
   // Finished looping over all nodes and did not find any, return null
   return null;
}