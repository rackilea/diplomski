public FamilyNode findNodeByName(FamilyNode nodeName ){
    if(this.name.equals(nodeName.name)){
        return this;
    } 
    for(FamilyNode child : this.children){
        FamilyNode found = child.findNodeByName(nodeName);
        if(found != null) 
            return found;
    }
    return null;
}