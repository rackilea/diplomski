public boolean equals(Stack<T> other) {
    //If they point to the same object return true
    if (stack == other) return true;
    //Check for nulls
    if (stack == null || other == null) return false;
    //If the stacks are not the same length, then they won't be equal, easy first test case
    if (stack.length != other.size()) return false;

    for(int i=0; i < stack.length; i++) {
           //Step through each item in both stacks, if any don't match return false
           if(!stack[i].equals(other.stack[i]) ) {
                  return false;
           }
    }

    //Haven't returned yet, they must be equal
    return true;
}