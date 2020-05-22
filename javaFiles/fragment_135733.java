final String[] name = new String[1];
        UIJob job = new UIJob("Get active editor") //$NON-NLS-1$
        {
            public IStatus runInUIThread(IProgressMonitor monitor)
            {
                try
                {
                    IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    name[0] = activePage.getActiveEditor().getEditorInput().getName();
                }
                catch (Exception e)
                {
                    // return some other status
                }

                return Status.OK_STATUS;
            }
        };
        job.schedule();
        job.join();
        System.out.println(name[0]);