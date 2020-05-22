int x = parentNode.getX()+25; // x position of first child
for (Nodes child : nodePrintList) {
    child.setX(x);
    child.setY(parentNode.getY()+50); // y position is same for each child
    // [...] fill rect, print, etc.
    x = paintComponent(g, child) - 50; // next x is left of the total width of the child
}
return x; // return x (change methods signature accordingly)