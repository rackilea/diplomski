@Override
public int[] getPath(FileObject node) {
    List<Integer> paths = new ArrayList<Integer>();
    try {
        FileObject parent = node.getParent();
        while (parent != null && parent.getType().equals(FileType.FOLDER)) {
            FileObject[] children = parent.getChildren();
            for( int index = 0; index < children.length; index++){
                FileObject c = children[index];
                if( node.equals(c)){
                    paths.add(index);
                    break;
                }
            }
            node = parent;
            parent = node.getParent();
        }
    } catch (FileSystemException e) {
        throw new IllegalArgumentException(e);
    }
    int[] p = new int[paths.size()];
    for( int index = 0; index < paths.size(); index++){
        p[index] = paths.get(p.length - 1 - index); // reverse
    }
    log.info(String.format("%s getPath on %s",level(node),innerName(node)));
    return p;
}