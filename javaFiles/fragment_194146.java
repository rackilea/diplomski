public boolean containsNodeRecursive(Node current, int value) {
    if (current == null) {
        return false;
    }

    if (value == current.data) {
        return true;
    }

    //HERE, THE RECURSIVE CALL IS PRECEDED BY A RETURN STATEMENT
    return value < current.data
      ? containsNodeRecursive(current.left, value)
      : containsNodeRecursive(current.right, value);
   }
}