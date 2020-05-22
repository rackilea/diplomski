Shell selectedShell = ... get the shell to highlight

Rectangle bounds = .. get bounds relative to absolute display

// create the highlight; want it to appear on top

Shell highlight = new Shell(selectedShell, SWT.NO_TRIM | SWT.MODELESS | SWT.NO_FOCUS | SWT.ON_TOP);

highlight.setBackground(display.getSystemColor(SWT.COLOR_RED));

Region highlightRegion = new Region();
highlightRegion.add(0, 0, 1, bounds.height + 2);
highlightRegion.add(0, 0, bounds.width + 2, 1);
highlightRegion.add(bounds.width + 1, 0, 1, bounds.height + 2);
highlightRegion.add(0, bounds.height + 1, bounds.width + 2, 1);

highlight.setRegion(highlightRegion);

highlight.setBounds(bounds.x - 1, bounds.y - 1, bounds.width + 2, bounds.height + 2);

highlight.setEnabled(false);

highlight.setVisible(true); // not open(): setVisible() prevents taking focus