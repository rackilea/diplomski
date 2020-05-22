JFrame frame = new JFrame("Main window");

frame.setSize( Toolkit.getDefaultToolkit().getScreenSize() );
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
frame.setUndecorated(false);

initLoginPanel(frame);

frame.setVisible(true); //FINALLY show the JFrame!