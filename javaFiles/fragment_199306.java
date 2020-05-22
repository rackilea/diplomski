Stack<Integer> stack = new Stack<Integer>();
    stack.push(1);
    stack.push(3);
    stack.push(5);
    stack.push(2);
    stack.push(4);

    Collections.sort(stack); // by virtue of design error!!!

    System.out.println(stack); // prints "[1, 2, 3, 4, 5]"
    while (!stack.isEmpty()) {
        System.out.println(stack.pop());
    } // prints "5", "4", "3", "2", "1"