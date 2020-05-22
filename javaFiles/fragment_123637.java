public ProductAllotmentEntryData recursive(root, code) { 
 if(root.code == code) 
    return root;
 }else{ 
    for(root.childs){ 
        object = recursive(child, code) 
        if(object!=null) 
            return object;
    } 
 return null;
 }