viewer.addSelectionChangedListener(new ISelectionChangedListener()
  {
    @Override
    public void selectionChanged(final SelectionChangedEvent event)
    {
      IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();

      txtMethodDescription.setText(descriptionMappernewer.get(selection.getFirstElement())));
    }
  });