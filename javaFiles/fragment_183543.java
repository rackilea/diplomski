public Element clone(){
    Element newCloneElement = new Element();
    newCloneElement.x = x;
    newCloneElement.y = y;
    return newCloneElement;
}
// The above method can implemented as static with an Element argument
// and the values will be copied from the argument.