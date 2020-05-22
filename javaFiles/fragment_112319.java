@Override
  protected Control createCustomArea( Composite parent ) {
    Link link = new Link( parent, SWT.WRAP );
    link.setText( "Please visit <a>this link</a>." );
    return link;
  }