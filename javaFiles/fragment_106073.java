class Block {

    ...

    boolean appendBlock(int atIndex, Block tree, boolean replace) {
        if (left == right == null)
            return false;

        if ((left != null) && (left.index == atIndex) {
            if (replace) 
                setLeft(tree);
        } else
            if ((right != null) && (right.index == atIndex)) {
                if (replace) 
                    setRight(tree);
            } else
                if ((left == null) || !left.appendBlock(atIndex, tree, replace))
                    if ((right == null) || !right.appendBlock(atIndex, tree, replace))
                        return false;

        return true;
    }

    ...

}