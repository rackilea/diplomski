public Node searchReturn(int key) {
    Node retVal = head;
    int i = 0;
    while(i < key) {
        if (retVal == null) {
            return null;
        }
        retVal = retVal.next();
        i++;
    }
    return retVal;
}