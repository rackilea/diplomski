if (previous != null)
previous.setLink(sameString.getLink());
// Link the node we are moving to the front node
sameString.setLink(getFront());
// Set the value of the front node to the node we are moving
setFront(sameString);