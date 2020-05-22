TabFolder tabFolder = new TabFolder(shell, SWT.NULL);

// Must set layout data for Shell GridLayout
tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

TabItem tab = new TabItem(tabFolder, SWT.NULL);

ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.H_SCROLL | SWT.V_SCROLL);
scrolledComposite.setExpandHorizontal(true);
scrolledComposite.setExpandVertical(true);

// ScrolledComposite ignores setLayout
// scrolledComposite.setLayout(new GridLayout(1, false));
// TabFolder doesn't use GridData
// scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

Composite innerComposite = new Composite(scrolledComposite, SWT.NULL);
for (int x = 0; x < 20; x++) {
    final Text t = new Text(innerComposite, SWT.BORDER);
    t.setText(x + "");
}
innerComposite.setLayout(new GridLayout(2, false));
innerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

scrolledComposite.setContent(innerComposite);

// MinSize should be the computed size of the inner composite
scrolledComposite.setMinSize(innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT)); 

tab.setControl(scrolledComposite);