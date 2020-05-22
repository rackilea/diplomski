if(sameString != getFront())
{
    sameString.setLink(getFront());
    // Set the value of the front node to the node we are moving
    setFront(sameString);
}