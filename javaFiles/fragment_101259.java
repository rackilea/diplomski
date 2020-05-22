public static Node selectionSort_asc(Node head){ 
    Node result = null;

    Node curr, prev, min, beforeMin;
    while(head!=null) {
        curr = head;
        prev = null;
        min = head;
        beforeMin = prev; // new variable
        while(curr.next!=null) {
            prev = curr; // update prev with each iteration
            curr = curr.next;
            if(curr.item<min.item) {
                beforeMin = prev; // variable points to the node before the min node
                min = curr;
            }
        }
        //append the min at the end of result list
        Node add_min = new Node(min.item);
        if(result==null)
            result = add_min;
        else {
            Node last = result;
            while(last.next!=null) {
                last = last.next;
            }
            last.next = add_min;
        }
        //delete the min node form original list    
        if(min==head) {
            head = head.next;
        }
        else if(min.next==null){
            beforeMin.next = null; // no more prev here
        }else {
            beforeMin.next = beforeMin.next.next; // notice how beforeMin is used now
            min.next = null;
        }
    }
    return result;
}