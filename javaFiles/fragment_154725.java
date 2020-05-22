private void insert(int value) {
        RedBlackNode parent = null;
        RedBlackNode current = root;

        while (current!=null){
            parent = current;

            if (value < current.key){
                current = x.left;
                //Here if you store the number of items on the left of a node increase it
            }           
            else{
                current = current.right;
                //Here if you store the number of items on the right  of a node increase it
            }
        }

        RedblackNode newNode=new RedBlackNode(value);

        newNode.p=parrent;

        // Here if parent is null the new node is root of the tree
        //if (parrent==null)
        //      root = newNode;  


        if (value < parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;
        // Usually we add it as RED and then fix the tree to comply with red black tree rules
        newNode.color=(RED);
        fixTree(newNode);
        }