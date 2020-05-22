public class StartupHook implements IStartup, ISelectionListener {

    @Override
    public void earlyStartup() {
        final IWorkbench workbench = PlatformUI.getWorkbench();
        workbench.addWindowListener(new IWindowListener() {

            @Override
            public void windowOpened(IWorkbenchWindow window) {
                addSelectionListener(window);
            }

            @Override
            public void windowClosed(IWorkbenchWindow window) {
                removeSelectionListener(window);
            }
            /* ... */
        });

        workbench.getDisplay().asyncExec(new Runnable() {
            public void run() {
                for (IWorkbenchWindow window : workbench.getWorkbenchWindows()) {
                    addSelectionListener(window);
                }
            }
        });
    }

    private void addSelectionListener(IWorkbenchWindow window) {
        if (window != null) {
            window.getSelectionService().addSelectionListener("org.eclipse.ui.navigator.ProjectExplorer", this);
        }
    }

    private void removeSelectionListener(IWorkbenchWindow window) {
        if (window != null) {
            window.getSelectionService().removeSelectionListener("org.eclipse.ui.navigator.ProjectExplorer", this);
        }
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        // TODO handle selection changes
        System.out.println("selection changed");
    }
}