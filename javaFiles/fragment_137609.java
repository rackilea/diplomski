// pseudo-code; not compilable

JPanel container = new JPanel();
container.setOpaque( true ); // make sure the container will be visible

JFrame frame = new JFrame();
frame.getContentPane().add(container); // add the container to the frame
frame. ... //other initialization stuff, like default close operation, maximize, etc

if ( fullScreenModeIsSupported )
    frame.setUndecorated( true ); // remove window decorations from the frame
    gs.setFullScreenWindow( frame );
    frame.validate();