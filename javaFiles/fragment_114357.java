// pseudocode:
public int maxSet(Posisjon<E> bt){
    if (visited[bt])
        return computedMax[bt];

    visited[bt] = true;        

    // You don't need to manually check for being a leaf
    // For leaves 'maxIfCurrentNodeIsSelected' is always larger.
    int maxIfCurrentNodeIsSelected = 1 + helper1(bt);
    int maxIfCurrentNodeIsNotSelected = helper2(bt);

    if (maxIfCurrentNodeIsSelected > maxIfCurrentNodeIsNotSelected) {
         shouldSelect[bt] = true;
         computedMax[bt] = maxIfCurrentNodeIsSelected;
    } else {
         shouldSelect[bt] = false;
         computedMax[bt] = maxIfCurrentNodeIsNotSelected;
    }
}

public Set getSelectionSet(Posisjon<E> bt, Set s) {
    if (shouldSelect[bt]) {
        s.Add(bt);

        // You should check for nulls, of course
        getSelectionSet(bt.leftChild.leftChild, s);
        getSelectionSet(bt.leftChild.rightChild, s);
        getSelectionSet(bt.rightChild.leftChild, s);
        getSelectionSet(bt.rightChild.rightChild, s);
    } else {
        getSelectionSet(bt.leftChild, s);
        getSelectionSet(bt.rightChild, s);
    }
    return s;
}