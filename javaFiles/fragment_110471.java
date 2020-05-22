@Override
protected Control createDialogArea(final Composite parent)
{
  Composite body = (Composite)super.createDialogArea(parent);

  // Vertical sash

  SashForm sashForm = new SashForm(body, SWT.VERTICAL);

  sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

  // First part, scrollable

  ScrolledComposite scrolledComp = new ScrolledComposite(sashForm, SWT.V_SCROLL);

  Composite comp1 = new Composite(scrolledComp, SWT.NONE);

  comp1.setLayout(new GridLayout());

  // TODO: add controls to comp1

  // Set scroll size - may need to adjust this

  Point size = comp1.computeSize(SWT.DEFAULT, SWT.DEFAULT);
  scrolledComp.setMinHeight(size.y);
  scrolledComp.setMinWidth(size.x);
  scrolledComp.setExpandVertical(true);
  scrolledComp.setExpandHorizontal(true);

  scrolledComp.setContent(comp1);

  // Second part

  Composite comp2 = new Composite(sashForm, SWT.NONE);

  comp2.setLayout(new GridLayout());

  // TODO: add controls to comp2

  // Third part

  Composite comp3 = new Composite(sashForm, SWT.NONE);

  comp3.setLayout(new GridLayout());

  // TODO: add controls to comp3

  // Set the sash weighting (must be after controls are created)

  sashForm.setWeights(new int [] {60, 30, 10});

  return body;
}