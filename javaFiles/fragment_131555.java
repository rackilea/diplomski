Timer lightTimer = new Timer( 2000, new ActionListener(){
  private int lightCounter = 0;
  @Override
  public void actionPerformed(ActionEvent e){
    switch( lightCounter ){
      case ...:
      final JButton lightButton = ...;
      lightButton.setBackground( regularColour );
      Timer blinkingTimer = new Timer( 1000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          lightButton.setColor( lightColour );
        }
      }
      blinkingTimer.setRepeats( false );
      blinkingTimer.start();
    }
    lightCounter++;
    if ( lightCounter == numberOfLights ){
      ((Timer)e.getSource()).stop();
    }
  }
} );
lightTimer.setRepeats( true );
lightTimer.start();