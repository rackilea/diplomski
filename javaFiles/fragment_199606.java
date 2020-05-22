Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
MessageDialog.openInformation(shell, "Project Proeperties", "Properties window will open next");

String propertyPageId = "org.eclipse.jdt.ui.propertyPages.BuildPathsPropertyPage";
PreferenceDialog dialog = PreferencesUtil.createPropertyDialogOn(shell, iProject, propertyPageId, null, null);
    dialog.open();