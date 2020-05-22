viewer.addDoubleClickListener(new IDoubleClickListener() {
    @Override
    public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection)event.getSelection();
    }
});