GridData data = (GridData)control.getLayoutData();  // Assumes layout was set earlier

data.exclude = false;   // Include control in the layout

control.setVisible(true);

....

parentComposite.layout(true);