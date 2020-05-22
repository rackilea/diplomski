public int getSome(int parentId){
    return nodes.stream().filter(n->{
        if(n.id==parentId) return true;
        Node c = n;
        while(c.parent!=null){
            c = c.parent;
            if(c.id==parentId) return true;
        }
        return false;
        }).mapToInt(n->n.value).sum();
    }
}