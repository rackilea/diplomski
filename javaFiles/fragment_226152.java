public void insert(String txt)
    {
      root = insert(root, new Node(txt));
    }

    private Node insert(Node parent, Node newNode)
    {
      if (parent == null)
      {
        return newNode;
      }

      final int comparison = newNode.data.compareTo(parent.data)
      if (comparison > 0)
      {
        parent.right = insert(parent.right, newNode);
      }
      else if (comparison < 0)
      {
        parent.left = insert(parent.left, newNode);
      }
      else { // If the new text matches the text of this node. parent.count++; }
      return parent;
    }