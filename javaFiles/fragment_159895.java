// WARNING: UNTESTED CODE
if (searchVal == nodeKey) {
    return 0;
} else if (searchVal < nodeKey && node.leftChild != EMPTY_NODE) {
    int childResult = recursiveContains(node.leftChild, searchVal);
    if (childResult != -1) { // Only use the child result if the value was found.
        return 1 + childResult;
    }
} else if (searchVal > nodeKey && node.rightChild != EMPTY_NODE) {
    int childResult = recursiveContains(node.rightChild, searchVal);
    if (childResult != -1) { // Only use the child result if the value was found.
        return 1 + childResult;
    }
}
// If you haven't returned by now, the value can't be found along this path.
return -1;