public class LinkedList {
  private Node head;
  private Node tail;
  private int numberOfElements;

  public LinkedList()
  {
      head = null;
      tail = null;
      numberOfElements = 0;
  }

  public int length()
  {
      return numberOfElements;
  }

  public void removeAtIndex(int index) 
  {
     if (index == 0) {
           Node q = head;
           head = q.getNextNode();
           numberOfElements--;
      }
      else if ((index > numberOfElements - 1) || (index < 0)) 
           System.out.println("Index out of bounds.");
      else {
        Node currNode = head;
        for (int i = 0; i < index; i++) {
            //Node p = currNode;
            System.out.println("At this payload " + currNode.getPayload());
            currNode = currNode.getNextNode();
            System.out.println("Now at this payload " + currNode.getPayload());
        }
        Node temp = currNode;
        System.out.println("Removing the node with payload " + temp.getPayload()); 
        currNode = temp.getPrevNode();
        currNode.setNextNode(temp.getNextNode());
        temp = null;
        numberOfElements--;
    }

  }

  public void add(int num) {
      Node newNode = new Node(num);
      newNode.setNextNode(null);
      if (numberOfElements == 0) {
          newNode.setPrevNode(null);
          head = newNode;
          tail = newNode;
        }
      else if (numberOfElements == 1) {
          head.setNextNode(newNode);
          tail = newNode;
          tail.setPrevNode(head);
        }
      else {
        newNode.setPrevNode(tail);
        tail.setNextNode(newNode);
        tail = newNode;
      }
      System.out.println("Inserted " + num + " into the linked list");
     numberOfElements++;
    }

  public void printList() {
      Node temp = head;
      while (temp != null) {
          System.out.println("Node with payload " + temp.getPayload());
          temp = temp.getNextNode();
        }
    }


  }