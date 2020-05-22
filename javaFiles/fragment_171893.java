int x = parentNode.getX()+25; // x position of first child
for (Nodes child : nodePrintList) {
    child.setX(x);
    child.setY(parentNode.getY()+50); // y position is same for each child
    // [...] fill rect, print, recursive call, etc.
    x -= 50; // in each iteration, move nodes further to the left
}