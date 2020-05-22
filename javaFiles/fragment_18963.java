if (node.left != null) {
      inOrder(node.left, result);
      result.append(", ");
}

result.append(node.left); //should not be node.left