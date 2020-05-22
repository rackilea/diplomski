public class TreePopulator implements IStartup
{

    @Override
    public void earlyStartup()
    {
        PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

            @Override
            public void run()
            {
                ViewMenuOffers viewMenuOffers = (ViewMenuOffers) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(ViewMenuOffers.ID);
                TreeViewer treeViewer = viewMenuOffers.getTreeViewer();
                Tree tree = treeViewer.getTree();

                TreeItem trtmS = new TreeItem(tree, SWT.NONE);
                trtmS.setText("Test");

            }

        });

    }

}