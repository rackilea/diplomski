public class FamilyNode {
    // ...
    // ...
    public FamilyNode findNodeByName(String nodeName){
       if(name.equals(nodeName)){
          // We found a node named nodeName, return it
          return this;
       } 
       // That's not me that you are looking for, let's see my kids
       for(FamilyNode child : children){
            if(child.findNodeByName(nodeName) != null) 
                // We found what we are looking, just return from here
                return child;
       }
       // Finished looping over all nodes and did not find any, return null
       return null;
    }

    public void addChild(FamilyNode child){
       children.add(child);
    }
}