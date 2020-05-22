public boolean contains(int ID) {
    for (PersonNode node : lst) {
        if (node.getID() == ID)
            return true; // node found, we can finish iterating
    }
    return false; // no node with id = ID was found
}