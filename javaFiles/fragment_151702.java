public Stack<Integer> copyStack(Stack<Integer> orig)  {
   Queue<Integer> q = new Queue<Integer>();
   q.addAll(orig);
   Stack<Integer> intStackCopy = new Stack<Integer>();
   intStackCopy.addAll(q);
   return  intStackCopy;
}