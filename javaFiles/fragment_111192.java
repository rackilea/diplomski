public Key delMax(){

    if(first==null) 
        return null;
    else if(n==1)
        return first.key;
    Node max=first,maxPrev=null,curr = max.next,prev = first;
    while(curr!=null){
        Key currMax = max.key;
        Key nextKey = curr.key;
        if(nextKey.compareTo(currMax)>0){
            max = curr;
            maxPrev = prev;
        }
        prev = curr;
        curr = curr.next;
    }
    if(maxPrev!=null)
        maxPrev.next=max.next;
    else
        first = max.next;
    n--;
    return max.key;
}