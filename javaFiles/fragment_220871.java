static void fillOtherStacks(Stack<Integer> from,
    Stack<Integer> stack2, Stack<Integer> stack3, Stack<Integer> stack4) {

    int value = from.pop(), x = value % 3;
    if(x == 0) stack2.push(x);
    else if(x == 1) stack4.push(x);
    else if(x == 2) stack3.push(x);
    if(!from.isEmpty())
        fillOtherStacks(from, stack2, stack3, stack4);// process the rest of stack
    from.push(value); // and push back the value

}