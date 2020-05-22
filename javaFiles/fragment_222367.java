public void delete(T element) {
    //In case, list is empty. 
    if(head == null) return;

    //If the head's value equals element, replace the head with its successor.
    if(head.value == element){
        head = head.next;
        delete(element);
        return;
    }
    //recursive call, if the head's value doesn't equal to the element anymore.
    delete_helper(element,head,head.next)
}

public void delete_helper(T element, Node pre, Node curr){
    //In case, curr's predecessor was the last element in the list.
    if(curr == null) return;

    //If the current value equals the element, skip the current node
    if(element == curr.value){
        pre.next = curr.next;
        delete_helper(element,pre,curr.next);
        return;
    }

    //recursive call with next node.
    delete_helper(element,curr,curr.next);
}