Stack<X> stack = text.reversed();
X elementFound = null;
while (!stack.isEmpty()) {
    if (txt.equals(stack.peek().getSecond()) {
        elementFound = stack.peek();
    } else {
        stackCopy.push(stack.peek());
    }
    stack.pop();
}
// now stack is empty and stackCopy contains stack reversed and without
// elementFound, if elementFound is not null (meaning it was found)
text = stackCopy; // stack was text reversed
return elementFound;