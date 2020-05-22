Stack<Node> stackA - push all elements of listA into stackA;
 Stack<Node> stackB - push all elements of listB into stackA;

 Node result=null;
 while(stackA.peek() == stackB.peek()){
    result = stackA.pop();
    stackB.pop();
 }
 return result;