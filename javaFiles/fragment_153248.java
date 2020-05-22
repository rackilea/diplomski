int cmpResult = target.compareTo(localRoot.data);
int localNodeVal = cmpResult < 0 ? 1 : 0; // This is the value for the current node by itself.
int valL = findMax(localRoot.left, target);
int valR = findMax(localRoot.right, target);
// Add the local node result with the evaluation of the left and right side.
return localNodeVal + valL + valR;