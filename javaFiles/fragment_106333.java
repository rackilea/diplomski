if(n != null){
    if(n.getLeft() != null){
        result = traverse(n.getLeft()); 
        // System.out.println(result.getValue());                
    }

    result = n;
    System.out.println(result.getValue()); // This prints the left and right via recursion into traverse(...)

    if(n.getRight() != null){     
        result = traverse(n.getRight());
        // System.out.println(result.getValue());
    }
}