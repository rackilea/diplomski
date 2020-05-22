public Collection<File> findAndCollectDuplicates( Node<File> root, File f )
{
    /* find a matching node; if none found, return an empty collection. */
    Node<File> node = findNode( root, f );
    if( node == null )
         return Collections.emptyList();

    /* collect duplicates and return them. */
    List<File> duplicates = new ArrayList<>();
    collectDuplicates( node, f, duplicates );
    return duplicates;
}

private Node<File> findNode( Node<File> root, File f )
{
    for(;;)
    {
        int result = f.compareTo( root.data );
        if (result == 0)
            return root;
        root = result < 0? root.leftChild : root.rightChild;
        if( root == null )
            return null;
    }
}

private void collectDuplicates( Node<File> node, File f, Collection<File> duplicates )
{
    if( node == null )
        return;
    if( f.compareTo( node.data ) != 0 )
        return;
    duplicates.add( node.data );
    collectDuplicates( node.leftChild );
    collectDuplicates( node.rightChild );
}