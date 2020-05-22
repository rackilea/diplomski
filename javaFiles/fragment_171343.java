private void initContent(Shell shell)
{
    // Configure shell
    shell.setLayout(new GridLayout());

    // Configure standard composite
    Composite standardComposite = new Composite(shell, SWT.NONE);
    standardComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

    // Configure scrolled composite
    ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
    scrolledComposite.setLayout(new GridLayout());
    scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    scrolledComposite.setExpandVertical(true);
    scrolledComposite.setExpandHorizontal(true);
    scrolledComposite.setAlwaysShowScrollBars(true);

    // Add content to scrolled composite
    Composite scrolledContent = new Composite(scrolledComposite, SWT.NONE);
    scrolledContent.setLayout(new GridLayout());
    scrolledComposite.setContent(scrolledContent);
}