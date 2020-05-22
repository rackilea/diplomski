@Override
  protected Control createMessageArea( Composite composite ) {
    Image image = getImage();
    if( image != null ) {
      imageLabel = new Label( composite, SWT.NULL );
      image.setBackground( imageLabel.getBackground() );
      imageLabel.setImage( image );
      GridDataFactory.fillDefaults().align( SWT.CENTER, SWT.BEGINNING ).applyTo( imageLabel );
    }
    if( message != null ) {
      Link link = new Link( composite, getMessageLabelStyle() );
      link.setText( "This is a longer nonsense message to show that the link widget wraps text if specified so. Please visit <a>this link</a>." );
      GridDataFactory.fillDefaults()
        .align( SWT.FILL, SWT.BEGINNING )
        .grab( true, false )
        .hint( convertHorizontalDLUsToPixels( IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH ), SWT.DEFAULT )
        .applyTo( link );
    }
    return composite;
  }
};