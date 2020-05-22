public void insertAtTheEnd(IValueElement value)
    {
        if (head.getSuccessor() != null)
        {
            IListElement l = head;
            while (l.getSuccessor() != null)
                l = l.getSuccessor();
            IListElement q = new ListElement(value);
            l.setSuccessor(q);
        }       

    else
        {
            IListElement q = new ListElement(value);
            q.setPredecessor(head);
            q.setSuccessor(null);
            head.setSuccessor(q);
        }
    }