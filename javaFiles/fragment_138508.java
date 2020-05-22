final Composite p = new Composite(parent, SWT.NONE);
p.setData(CSS_CLASS_KEY, "container");
p.setBackgroundMode(SWT.INHERIT_DEFAULT);
p.setLayout(new GridLayout(2, false));

Label l = new Label(p, SWT.NONE);
l.setData(CSS_CLASS_KEY, "h2");
l.setText("This is a headline");
l.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 2, 1));

engine.applyStyles(p, true); // Apply the CSS-Instructions of the current active theme