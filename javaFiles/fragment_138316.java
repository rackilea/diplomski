Text textFour = new Text(shell, SWT.BORDER);
GridData data = new GridData(SWT.LEFT, SWT.CENTER, false, false);
textFour.setLayoutData(textFour);

Combo comboFour = new Combo(shell, ... style ...);
comboFour.setVisible(false);   // Not visible
data = new GridData(SWT.LEFT, SWT.CENTER, false, false);
data.exclude = true;   // Exclude from layout
comboFour.setLayoutData(data);