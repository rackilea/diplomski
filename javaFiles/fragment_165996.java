private Node insert(Node node, int data) {
            if (node == null) {
                node = new Node(data);
            }
            else {
                if (data <= node.data) {
                    node.left = insert(node.left, data);
                   }
                else {
                    node.right = insert(node.right, data);
                     }
                 }
                 return (node);
        }