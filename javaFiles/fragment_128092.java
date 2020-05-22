public class VfsTreeModel extends AbstractTreeModel<FileObject> {

// __ snip __

@Override
public FileObject getChild(FileObject parent, int index) {
    log.info(String.format("%s getChild on %s with index %s", level(parent), innerName(parent), index));
    FileObject child = null;
    try {
        FileObject[] children = parent.getChildren();
        child = children[index];
    } catch (FileSystemException e) {
        throw new IllegalArgumentException(e);
    }
    return child;
}

@Override
public int getChildCount(FileObject node) {
    int childCount = 0;
    try {
        FileType type = node.getType();
        if( type == FileType.FOLDER ){
            childCount = node.getChildren().length;
        }
    } catch (FileSystemException e) {
        throw new IllegalArgumentException(e);
    }
    log.info(String.format("%s getChildCount on %s returning %s",level(node),innerName(node), childCount));
    return childCount;
}

@Override
public boolean isLeaf(FileObject node) {
    boolean isLeaf = false;
    try {
        FileType type = node.getType();
        isLeaf = (type == FileType.FILE );
    } catch (FileSystemException e) {
        throw new IllegalArgumentException(e);
    }
    log.info(String.format("%s isLeaf on %s returning %s", level(node),innerName(node), isLeaf));
    return isLeaf;
}