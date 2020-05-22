protected Control createDialogArea(Composite parent) {
    composite = (Composite) super.createDialogArea(parent);

    // Create the Group on the top level Composite
    grpModelProperties1 = new Group(composite, SWT.SHADOW_IN);
    GridData data1 = new GridData(SWT.FILL, SWT.TOP, true, false);
    data1.heightHint = 200;
    grpModelProperties1.setLayoutData(data1);
    grpModelProperties1.setLayout(new GridLayout());
    grpModelProperties1.setText("Test Model");

    // Within the Group, create the ScrolledComposite
    ScrolledComposite scrolledComposite = new ScrolledComposite(grpModelProperties1, SWT.H_SCROLL | SWT.V_SCROLL);
    scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    scrolledComposite.setExpandHorizontal(true);
    scrolledComposite.setExpandVertical(true);
    // Create the scrolled content (the inner composite)
    Composite innerComposite = new Composite(scrolledComposite, SWT.NONE);
    innerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    innerComposite.setLayout(new GridLayout());

    // Some misc. data to test the scrolling
    final Label label = new Label(innerComposite, SWT.NONE);
    label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    label.setText("a\nb\nc\nd\ne\nf\ng\nh\ni\nj\nk\nl\nm\nn\no\np\nq\nr");

    scrolledComposite.setContent(innerComposite);
    scrolledComposite.setMinSize(innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    return composite;
}