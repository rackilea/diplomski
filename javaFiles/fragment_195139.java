public boolean insert(E s) 
{
    try {
        root = insert(s, root);
        root.setParent(findParent(root.getData()));
        return true;
    } catch (Exception e) {
        return false;
    }
}