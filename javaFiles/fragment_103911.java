public class MyFrameMain extends JFrame{
    private final JLabel iLabel;
    private final JLabel nLabel;
    private final JTextField iJTextField;
    private final JTextField nJTextField;
    private final JTextField swTextField;
    private final JTextField hwTextField;
    private final JLabel jItemCounter;
    private final JTextArea reSoulte;
    private final JButton addButton;
    private final JButton showButton;
    private final JButton copyButton;
    private final JButton exitButton;
    JRadioButton rButton1 = new JRadioButton("SW Version",false);
    JRadioButton rButton2 = new JRadioButton("HW Type",false);
    JRadioButton rButton3 = new JRadioButton("General",true); 

    public MyFrameMain(String title){