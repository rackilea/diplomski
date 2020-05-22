// different sizes, can't be equal
if(this.parts.size() != other.parts.size()){
    return false;
}

// get iterators
Iterator<String> left = this.parts.iterator();
Iterator<String> right = other.parts.iterator();

// safe to only check `left` because the lists are the same size
while(left.hasNext()){
    // check if left part is equal to the right part
    if(!left.next().equals(right.next())){
        // values are different, know at this
        // point they're not equal
        return false;
    }
}

// at this point, have exactly the same values
// in the same order.
return true;