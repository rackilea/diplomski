IViewPart part = .. find package explorer view part

IViewSite viewSite = part.getViewSite();

ISelectionProvider provider = viewSite.getSelectionProvider();

ISelection selection = provider.getSelection();