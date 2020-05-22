public class WQQuery extends JFrame implements WindowListener,ActionListener,Runnable {

    JButton button1;
    JLabel InterFaceLabel;
    JLabel ErrorCodeLabel;
    JTextField InterFaceField;
    JTextField ErrorCodeField;
    JTextArea SQLLabel = new JTextArea(2,20);
    String InterFace = "";
    String ErrorCode = "";