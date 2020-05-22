public MainScreen() {

    JFrame frame = new JFrame();
    frame.setTitle("Project");//Title of the screen
    frame.setSize(800,600);//Size of the window
    frame.setResizable(false);//Is the window resizable?
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Exit the frame when the default red cross is clicked
    frame.setVisible(true);//is the frame visible?
    frame.getContentPane().add(cardContainer, BorderLayout.CENTER);//add the cardcontainer to flip panels
    frame.setLocationRelativeTo(null);
}