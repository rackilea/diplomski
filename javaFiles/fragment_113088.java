public static void main(String args[]) {

    Stack stack = new Stack();

    for (int i = 1; i <= 10; i++) 
        stack.push(new Integer(i));


    while (!stack.empty())
        System.out.print(stack.pop() + " ");


    System.out.println(" No element in stack");
}