editor.addPropertyListener(new IPropertyListener() {
    @Override
    public void propertyChanged(Object source, int propId) {
        if (propId == IWorkbenchPartConstants.PROP_DIRTY) {
            System.out.println("'Dirty' Property Changed");
        }
    }
});