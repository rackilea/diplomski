public void printLevelOrder(Node<T> root)
    {
        int h = height(root);//Calculate height of the tree
        int i;
        for (i=1; i<=h; i++)
        {
            printGivenLevel(root, i);
            System.out.println();
        }
    }
    private void printGivenLevel(Node<T> root, int height) {
         if (root == null)
                return;
            if (height == 1)
                System.out.print(root.value);
            else if (height > 1)
            {
                printGivenLevel(root.left, height-1);
                printGivenLevel(root.right, height-1);
            }

    }