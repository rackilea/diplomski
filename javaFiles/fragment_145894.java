public String get(String animal)
    {
        Node temp = head;
        while (temp!=null)
        {
            if (animal.equals(temp.topList))
            {
                return temp.botList;
            }
            temp = temp.next;
        }
        return null;
    }