@Override
protected Composite createToolTipContentArea(final Event event, final Composite parent)
{
  Composite body = new Composite(parent, SWT.NONE);

  body.setLayout(new GridLayout());

  Label label = new Label(body, SWT.LEAD);

  Image image = ... your image

  label.setImage(image);

  return body;
}