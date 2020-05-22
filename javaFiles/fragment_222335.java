KeyType getSmallestKey (Node root)
{
    minLeft = MAX_VALUE
    minRight = MAX_VALUE
    if root.hasLeftChild
        minLeft = getSmallestKey(root.left)
    if root.hasRightChild
        minRight = getSmallestKey(root.right)
    return min (minLeft, minRight, root.getKey)
}