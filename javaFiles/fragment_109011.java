/* Function to remove duplicates from an 
   unsorted linked list */
void remove_duplicates() { 
    Node ptr1 = null, ptr2 = null, dup = null; 
    ptr1 = head; 

    /* Pick elements one by one */
    while (ptr1 != null && ptr1.next != null) { 
        ptr2 = ptr1; 

        /* Compare the picked element with rest 
            of the elements */
        while (ptr2.next != null) { 

            /* If duplicate then delete it */
            if (ptr1.data == ptr2.next.data) { 

                /* sequence of steps is important here */
                dup = ptr2.next; 
                ptr2.next = ptr2.next.next; 
                System.gc(); 
            } else /* This is tricky */ { 
                ptr2 = ptr2.next; 
            } 
        } 
        ptr1 = ptr1.next; 
    } 
}