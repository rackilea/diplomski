Node slow, fast, start;
fast = slow = head;

//PART I - Detect if a loop exists
while (true)
{
    // fast will always fall off the end of the list if it is linear
    if (fast == null || fast.next == null)
    {
        // no loop
        return;
    }
    else if (fast == slow || fast.next == slow)
    {
        // detected a loop
        break;
    }
    else
    {
        fast = fast.next.next; // move 2 nodes at at time
        slow = slow.next; // move 1 node at a time
    }
}

//PART II - Identify the node that is the start of the loop
fast = head; //reset one of the references to head of list

//until both the references are one short of the common element which is the start of the loop
while(fast.next != slow.next) 
{
    fast = fast.next;
    slow = slow.next;
}

start = fast.next;

//PART III - Eliminate the loop by setting the 'next' pointer 
//of the last element to null
fast = start;
while(fast.next != start)
{
    fast = fast.next;
}

fast.next = null; //break the loop