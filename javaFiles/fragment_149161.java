IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

IEditorReference[] refs = page.getEditorReferences();

for (IEditorReference reference : refs) {

   IEditorInput input = reference.gtEditorInput();

   IPath path = getPathFromEditorInput(input);
   if (path != null)
    {
      System.out.println(path.toOSString());
    }
}


private static IPath getPathFromEditorInput(IEditorInput input)
{
  if (input instanceof ILocationProvider)
    return ((ILocationProvider)input).getPath(input);

  if (input instanceof IURIEditorInput)
   {
     URI uri = ((IURIEditorInput)input).getURI();
     if (uri != null)
      {
        IPath path = URIUtil.toPath(uri);
        if (path != null)
          return path;
      }
   }

  if (input instanceof IFileEditorInput)
   {
     IFile file = ((IFileEditorInput)input).getFile();
     if (file != null)
      return file.getLocation();
   }

  return null;
}