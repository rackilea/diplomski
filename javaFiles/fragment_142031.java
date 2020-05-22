IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

IViewPart viewPart = page.findView("your view id");

MyViewClass myViewClass = (MyViewClass)viewPart;

// TODO call a method in MyViewClass to set the text