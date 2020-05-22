public boolean compareTrees(BinaryTree other) {

      if (left == null) != (other.left == null) return false;
      if (right == null) != (other.right == null) return false;

      if (left != null && !left.compareTrees(other.left)) return false;
      if (right != null && !right.compareTrees(other.right)) return false;

      return true;
  }