public void add(int index, E element)  // insert an element in the list 
 {
     // if index is less than 0 or greater than the length
      if( (index < 0) || (index > length ) ) {
           throw new IndexOutOfBoundsException();
      }

      // Find insertion point
      SLNode<E> current = Head;
      for (int i = 0; i < index; i++) {
          current = current.getSuccessor();
      }

      // Create & insert new node
      SLNode<E> newnode = new SLNode<E>(element, null);
      newnode.setSuccessor(current.getSuccessor());  
      current.setSuccessor( newnode);
      length++;
  }