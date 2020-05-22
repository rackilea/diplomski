GridData data = (GridData)control.getLayoutData();  // Assumes layout was set earlier

data.exclude = true;   // Don't include control in the layout

control.setVisible(false);

....

parentComposite.layout(true);