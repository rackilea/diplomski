@Override
protected TreeViewer createTreeViewer(final Composite parent)
{
  TreeViewer viewer = super.createTreeViewer(parent);

  viewer.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);

  return viewer;
}