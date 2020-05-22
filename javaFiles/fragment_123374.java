String compareString = "Black";
Stack<String> auxStack = new Stack<String>();
while(!stack.isEmpty()) {
    String st = stack.pop();
    if(st.compareTo(compareString) != 0)
        auxStack.push(st);
}

while(!auxStack.isEmpty()) 
    stack.push(auxStack.pop());