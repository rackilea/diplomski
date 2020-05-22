Listener filter = new Listener() {
  IContextActivation activation;
  @Override
  public void handleEvent( Event event ) {
    if( isEditingWidget( event.widget ) ) {
      if( event.type = SWT.FocusIn ) {
        contextService.deactivateContext( activation );
      } else {
        activation = contextService.activateContext( "context id" );
      }
    }
  }
};
display.addFilter( SWT.FocusIn, filter );
display.addFilter( SWT.FocusOut, filter );