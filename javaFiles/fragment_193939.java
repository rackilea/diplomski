// Creation of the JScrollPane: Make the view a panel, having a BoxLayout manager for the Y-axis
JPanel view = new JPanel( );
view.setLayout( new BoxLayout( view, BoxLayout.Y_AXIS ) );
JScrollPane spn = new JScrollPane( view );

// The component you wish to add to the JScrollPane
Component ctrl = ...;

// Set the alignment (there's also RIGHT_ALIGNMENT and CENTER_ALIGNMENT)
ctrl.setAlignmentX( Component.LEFT_ALIGNMENT );

// Adding the component to the JScrollPane
JPanel pnl = (JPanel) spn.getViewport( ).getView( );
pnl.add( ctrl );
pnl.revalidate( );
pnl.repaint( );
spn.revalidate( );