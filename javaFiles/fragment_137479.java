public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JTextField textField = new JTextField();
        InputMap inputMap = textField.getInputMap( JComponent.WHEN_FOCUSED );
        KeyStroke[] keyStrokes = inputMap.allKeys();
        for ( int i = 0; i < keyStrokes.length; i++ ) {
          KeyStroke keyStroke = keyStrokes[ i ];
          Object value = inputMap.get( keyStroke );
          System.out.println(keyStroke + "-\"" + value + "\"");
        }
      }
    } );
  }