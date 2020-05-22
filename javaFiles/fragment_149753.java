Student top = null;
while(!s.isEmpty() && !e.equals(top)){
    top = s.pop();
}
if(e.equals(top)) {
    s.push(top);
} else {
    // e was not on the stack
}