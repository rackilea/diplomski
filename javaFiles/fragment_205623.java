@Override
public boolean contains(E elem) {
    int compare = elem.compareTo(value); //here we compare the element with 
                                         //the compareTo method that the objects 
                                         //used must redefined

    if(compare==0)
            return true; //here the current node contains elem !
        else if(compare < 0)
            return left.contains(elem); //elem is inferior than the elem present in the current node hence we look into the left part of the tree
        else
            return right.contains(elem); //elem is superior than the elem present in the current node hence we look into the right part of the tree
    }