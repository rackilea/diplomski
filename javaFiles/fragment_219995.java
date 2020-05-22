// Retrieve existing composite
Composite composite = [retrieve existing composite]

// Remove exising children
for (Control child : composite.getChildren()) {
     child.dispose();
}

// Create new children
Label label = new Label(composite, SWT.NONE);

// Layout
// Maybe update the composite layout with composite.setLayout()
composite.layout(true, true);