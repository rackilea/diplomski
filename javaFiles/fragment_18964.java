if (node.left != null) {
     inOrder(node.left, result);
     result.append(", ");
}

result.append(node); //this will print the node itself