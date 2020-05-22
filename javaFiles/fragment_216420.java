public GlobalInfo getRootParent(){
    if(this.parent == null){
        return null;
    }

    GlobalInfo result = this;
    while(result.parent != null){
        result = result.parent;
    }

    return result;
}