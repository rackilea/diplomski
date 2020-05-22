if ( elem.compareTo( root.element ) < 0 ) {
        if ( root.left == null )
             root.left = new BSTNode( elem );
        else
            insertR( root.left, elem );
    } else {
        if ( root.right == null )
             root.right = new BSTNode( elem );
        else
             insertR( root.right, elem );
    }