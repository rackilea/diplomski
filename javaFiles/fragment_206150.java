protected Composite getFieldEditorParent() {
    if (style == FLAT) {
        // Create a new parent for each field editor
        Composite parent = new Composite(fieldEditorParent, SWT.NULL);
        parent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        return parent;
    }
    // Just return the parent
    return fieldEditorParent;
}