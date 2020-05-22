/**
 * Make the frame and everything in it
 */
private void makeFrame()
{
frame = new JFrame("Adventure!");

JPanel contentPane = (JPanel)frame.getContentPane();
contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
contentPane.setLayout(new GridLayout(0, 1));

textArea = new JTextArea(20, 50);       
textArea.setEditable(false);
textArea.setLineWrap(true);
textArea.setFont(new Font("font", Font.BOLD, 15));
JScrollPane scrollPane = new JScrollPane(textArea);
contentPane.add(textArea);


//This replaces your JOptionPane block
    buttonPane = new JPanel();
    buttonPane.setLayout(new GridLayout(0, 1));
    contentPane.add(buttonPane);

frame.pack();
// place the frame at the center of the screen and show
Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
frame.setVisible(true);
}