if(prev == null)
        {
            node.next = parent;
        }
        else
        {
            node.next = prev.next;
            prev.next = node;
        }