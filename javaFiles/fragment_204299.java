// check whether there is already one of them on top
if (line.charAt(i) == theStack.peek()) { // un-boxing to char
   theStack.pop();
}
// else push new one on top
else {
    theStack.push(line.charAt(i));
}