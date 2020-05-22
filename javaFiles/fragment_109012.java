/* Function to remove duplicates from a 
       unsorted linked list */
    static void removeDuplicate(node head)  
    { 
        // Hash to store seen values, changed a little to compile for Java 8
        HashSet<Integer> hs = new HashSet<Integer>(); 

        /* Pick elements one by one */
        node current = head; 
        node prev = null; 
        while (current != null)  
        { 
            int curval = current.val; 

             // If current value is seen before 
            if (hs.contains(curval)) { 
                prev.next = current.next; 
            } else { 
                hs.add(curval); 
                prev = current; 
            } 
            current = current.next; 
        } 

    }