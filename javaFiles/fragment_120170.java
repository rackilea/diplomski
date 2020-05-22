public ArrayList<File> collectTree( Node<File> root )
{
    List<File> files = new ArrayList<>();
    collectTree( root, files );
    return files;
}

private void collectTree( Node<File> node, ArrayList<File> files )
{
    if( node == null )
        return;
    collectTree( node.leftChild, files );
    files.add( node.data );
    collectTree( node.rightChild, files );
}