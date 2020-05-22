textFour.setVisible(false);
GridData data = (GridData)textFour.getLayoutData();
data.exclude = true;

comboFour.setVisible(true);
data = (GridData)comboFour.getLayoutData();
data.exclude = false;

shell.layout(true);   // Tell shell to redo the layout