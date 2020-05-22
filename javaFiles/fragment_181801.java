Display display = Display.getDefault();
Shell shell new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);

// make the region for the main window
// circle is a method that returns a list of points defining a circle
Region region = new Region();
region.add(350, 0, 981, 51);
region.add(circle(380,51,30));
region.add(circle(951,51,30));
region.add(380, 51, 571, 30);
shell.setRegion(region);
Rectangle rsize = region.getBounds();
shell.setSize(rsize.width, rsize.height);

Composite main = new Composite(shell, SWT.NULL);

// make the label
cpyLbl = new Label(main, SWT.NONE);
cpyLbl.setText("Copy");

cpyLbl.setBackground(SWTResourceManager.getColor(38,255,23));

Region cpyRegion = new Region();
cpyRegion.add(0, 0, 161, 51);
cpyRegion.add(circle(28,51,28));
cpyRegion.add(28, 51, 133, 28);
cpyLbl.setRegion(cpyRegion);

// the top left of the bounds is the 0,0 of the region coordinates
// bounds are in screen coordinates (maybe shell coordinates?)
cpyLbl.setBounds(352, 0, 161, 79);
cpyLbl.setVisible(true);