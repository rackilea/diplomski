public int getLastIndexOf(value) {
    return getLastIndexOf(head, value);
}

private int getLastIndexOf(sublist, value) {
    //check the tail first (because we want last index)
    if (sublist.tail != null) {//list has a tail
        int lastIndexInTail = getLastIndexOf(sublist.tail, value); //recursion
        if(lastIndexInTail != -1)
          return lastIndexInTail + 1; //it's in the sub list, the sub list starts at idx 1
    }

    // it's not in the tail, check this head
    if (sublist.data == value){
      return 0; //it's at the front of this list
    }

    return -1; //it's not in the head or in the tail of sublist
}