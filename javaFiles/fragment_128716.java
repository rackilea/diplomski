public boolean insert(T value) {     
    if (isEmpty()) {              
        root = new BinarySearchTreeNode((T) value, null, null);  
        return true;  
    }
    return insert((T) value, root); // start recursion  
}