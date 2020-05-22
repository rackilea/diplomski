import org.eclipse.jdt.internal.ui.packageview.PackageExplorerPart;

...

PackageExplorerPart part= PackageExplorerPart.getFromActivePerspective();
IResource resource =  /*any IResource to be selected in the explorer*/;

part.selectAndReveal(resource);