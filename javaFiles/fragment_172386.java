Display display = new Display();

Shell shell = new Shell(display, SWT.SHELL_TRIM);

shell.setText("Stack Overflow");

shell.setFullScreen(true);

shell.setLayout(new GridLayout());

// Composite, just using a border here to show where it is
Composite composite = new Composite(shell, SWT.BORDER);

// Center composite in the shell using all available space 
composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

composite.setLayout(new GridLayout());

// Something to put in the composite
Label label = new Label(composite, SWT.BEGINNING);
label.setText("Text");

shell.open();

while (!shell.isDisposed()) {
    if (!display.readAndDispatch())
      display.sleep();
  }

display.dispose();