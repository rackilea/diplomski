public void deleteLast(Node node,Node temp,Node prev, int data)
    {
        if(node==null)
        {
          if(temp!=null && temp.next.next!=null){
          temp.next = temp.next.next;}
          if(temp.next.next==null)
          temp.next = null;
          return;
        }
        if(node.data==data)
        {
          temp = prev;
        }

        prev = node;
        deleteLast(node.next, temp, prev, int data);

    }