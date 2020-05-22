public void reversePrinter() {
    Stack stack = new Stack();        //create a stack for reversing order
    Iterator<E> it = this.iterator(); //get this object's iterator
    while(it.hasNext())               //while there is still another object
      stack.push(it.next());          //add the next object to the stack

    while(!stack.empty())             //while the stack is not empty
      System.out.print(stack.pop());  //print the data from the stack
}