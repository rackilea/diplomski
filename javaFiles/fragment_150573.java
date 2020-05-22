Image image = new Image(display, "c:\\picture.jpeg"); 
 Shell shell = new Shell(SWT.NO_TRIM);
 shell.setBounds(10,10,200,200);
 shell.setBackgroundImage(image);
 shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
 Label label = new Label(shell, SWT.NONE);
 label.setText("LAbel text here. ");