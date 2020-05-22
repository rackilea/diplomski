private void toArray(BSTNode<E> node, List<E> aList)
    {
        if(node != null)
        {
            toArray(node.left, aList);
            aList.add(node.data);
            toArray(node.right, aList);
        }
    }