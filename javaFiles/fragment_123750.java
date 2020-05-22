Composite composite = new Composite(parent, SWT.NULL);
composite.setLayout(new GridLayout());

Group grpModelProperties = new Group(composite, SWT.SHADOW_IN);
grpModelProperties.setText("ETL Transformation Model");
grpModelProperties.setLayout(new GridLayout(2, false));

// Layout data for the group in the composite,
// Fill the row, stays at the top of the dialog
grpModelProperties.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));