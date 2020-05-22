BinaryTree binarySearchTree = new BinaryTree(
        new BinaryNode(12, 
                new BinaryNode(8,
                        new BinaryNode(5,
                                new BinaryNode(3),
                                null),
                        new BinaryNode(9)),
                new BinaryNode(14,
                        null,
                        new BinaryNode(34,
                                new BinaryNode(24),
                                new BinaryNode(35)))));
binarySearchTree.plot();