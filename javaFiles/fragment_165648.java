if(dialog.open == SWT.OK) {
// using a getter method, get the model from the dialog.
DialogModel dialogModel = dialog.getModel();
// add it to the list of models set as input to the tableViewer
tableViewerEntries.add(dialogModel);
// Refresh table to set the new element in the tableviewer.
tableViewer.refresh();
}