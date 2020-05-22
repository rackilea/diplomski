final ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
            scrolledComposite.setExpandHorizontal(true);
            scrolledComposite.setExpandVertical(true);

            final Composite composite_parent = new Composite(scrolledComposite, SWT.NONE);
            composite_parent.setLayout(new GridLayout(3, false));
            scrolledComposite.setContent(composite_parent);
            scrolledComposite.setSize(composite_parent.computeSize(SWT.DEFAULT, SWT.DEFAULT));

            final Composite composite_child = new Composite(composite_parent, SWT.NONE);
            composite_child.setLayout(new GridLayout(2, false));

            final Label lblDefault1 = new Label(composite_child, SWT.NONE);
            lblDefault1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
            lblDefault1.setText("Name");

            final StyledText textStyled = new StyledText(composite_child, SWT.NONE);
            textStyled.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));

            Label lblNewLabel_1 = new Label(composite_child, SWT.NONE);
            lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
            lblNewLabel_1.setText("Path");

            text = new Text(composite_child, SWT.BORDER);
            text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

            scrolledComposite.setMinSize(composite_parent.computeSize(SWT.DEFAULT, SWT.DEFAULT));