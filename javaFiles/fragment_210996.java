public class LeafOnlyTreeSelectionModel extends DefaultTreeSelectionModel
{
private static final long serialVersionUID = 1L;

private TreePath[] augmentPaths(TreePath[] pPaths)
{
    ArrayList<TreePath> paths = new ArrayList<TreePath>();

    for (int i = 0; i < pPaths.length; i++)
    {
        if (((DefaultMutableTreeNode) pPaths[i].getLastPathComponent()).isLeaf())
        {
            paths.add(pPaths[i]);
        }
    }

    return paths.toArray(pPaths);
}

@Override
public void setSelectionPaths(TreePath[] pPaths)
{
    super.setSelectionPaths(augmentPaths(pPaths));
}

@Override
public void addSelectionPaths(TreePath[] pPaths)
{
    super.addSelectionPaths(augmentPaths(pPaths));
}