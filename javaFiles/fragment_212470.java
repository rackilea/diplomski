class SampleDialog extends JDialog {
/**
 * The constructor creates the window with all the controls.
 * Constructor takes a JFrame object
 */
SampleDialog(JFrame jframe) {
    //pass the parameters to the superclass(JDialog)
    super(jframe,true);
    Container pane = getContentPane();      
    JPanel panel = new JPanel();
    pane.add(panel);
    JTextField userText = new JTextField(20);
    userText.setBounds(100, 10, 160, 25);
    panel.add(userText);
    WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSED);
    this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    });
    setSize(200, 200);
    setVisible(true);      
}
public static void main(String[] args) throws IOException {
    SampleDialog sampleDialog = new SampleDialog(new JFrame());
}}