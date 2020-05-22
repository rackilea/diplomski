IViewPart [] parts =
      MyPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getViews();
    IProject activeProject = null;

    for(int i=0;i<parts.length;i++)
    {
        if(parts[i] instanceof ResourceNavigator)
        {
            ResourceNavigator navigator = (ResourceNavigator)parts[i];
            StructuredSelection sel   =
              (StructuredSelection)navigator.getTreeViewer().getSelection();
            IResource resource = (IResource)sel.getFirstElement();
            activeProject = resource.getProject();
            break;
        }
    }
    String activeProjectName = activeProject .getName();