frame.addComponentListener( new ComponentListener() {
      public void componentResized( ComponentEvent e ) {}
      public void componentMoved( ComponentEvent e ) {
         setLocation( FIX_X, FIX_Y );
      }
      public void componentShown( ComponentEvent e ) {}
      public void componentHidden( ComponentEvent e ) {}
 } );