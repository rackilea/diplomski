cancelButton.addTraverseListener(new TraverseListener () {
public void keyTraversed(TraverseEvent e) {
e.doit=false;
if (e.keyCode==16777218) {
userIdText.forceFocus();
} else if (e.keyCode==16777217) {
connectButton.forceFocus();
}
else {
//do nothing,i guess;
}
}
});