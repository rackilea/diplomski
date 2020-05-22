public void sort()
  {
    for (int i = size - 1; i >= 1; i--)
    {
      Node<E> finalNode = head;
      Node<E> tempNode = head;

      for (int j = 0; j < i; j++)
      {
        E val1 = head.element;
        Node<E> nextnode = head.next;
        E val2 = nextnode.element;
        if (val1.compareTo(val2))
        {
          if (head.next.next != null)
          {
            Node<E> CurrentNext = head.next.next;
            nextnode.next = head;
            nextnode.next.next = CurrentNext;
            if (j == 0)
            {
              finalNode = nextnode;
            }
            else
              head = nextnode;

            for (int l = 1; l < j; l++)
            {
              tempNode = tempNode.next;
            }

            if (j != 0)
            {
              tempNode.next = nextnode;

              head = tempNode;
            }
          }
          else if (head.next.next == null)
          {
            nextnode.next = head;
            nextnode.next.next = null;
            for (int l = 1; l < j; l++)
            {
              tempNode = tempNode.next;
            }
            tempNode.next = nextnode;
            nextnode = tempNode;
            head = tempNode;
          }
        }
        else
          head = tempNode;
        head = finalNode;
        tempNode = head;
        for (int k = 0; k <= j && j < i - 1; k++)
        {
          head = head.next;
        }

      }
    }
  }