Shell shell = new Shell(display, SWT.SHELL_TRIM);

shell.setLayout(new GridLayout());

StyledText text = new StyledText(shell, SWT.V_SCROLL | SWT.H_SCROLL);

text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

text.setText(....);

shell.layout();

Point size = shell.computeSize(SWT.DEFAULT, SWT.DEFAULT);

shell.setSize(Math.min(size.x, 100), Math.min(size.y, 100));

shell.open();