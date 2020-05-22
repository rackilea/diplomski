boolean equalTrees(Node lhs, Node rhs)
{
    // Empty trees are equal
    if (lhs == null && rhs == null)
        return true;

    // Empty tree is not equal to a non-empty one
    if ((lhs == null && rhs != null)
        || (lhs != null && rhs == null))
        return false;

    // otherwise check recursively
    return equalTrees(lhs.left(), rhs.left())
        && equalTrees(lhs.right(), rhs.right())
}