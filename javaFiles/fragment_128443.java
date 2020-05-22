// Get the current page

IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
IWorkbenchPage page = window.getActivePage();

// Get IFile

IPath path = new Path("workspace relative path");
IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);

// Open default editor for the file

IDE.openEditor(page, file, true);