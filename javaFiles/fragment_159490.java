FormData fd;
//row 1
Label lblC1R1;
Control ctrlC2R1;
//row 2
Label lblC1R2;
Control ctrlC2R2;

...

fd = new FormData(); //for ctrlC2R2;
fd.top = new FormAttachment(lblC1R1);  //top edge clings to (y-coord of) bottom of row 1 label (could reference row 1 control, too)
fd.left = new FormAttachment(lblC1R2); //left edge clings to right side of row 2 label
fd.right = new FormAttachment(lblC1R2, 200, SWT.RIGHT); //right edge is defined as a distance of +200 px from *right* side of row 2 label (by default, it would use the left side)
//we don't set fd.bottom, so the control may grow or shrink with ie. font size

ctrlC2R2.setLayoutData(fd);