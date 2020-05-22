public class CardLayoutExample
{

 private void displayGUI()
 {


    contentPane.add(panel1, "Panel 1");
    contentPane.add(panel2, "Panel 2");
    // call show after adding not before 
    cl.show(contentPane, "Panel 1");
}
// same as before only change in MyPanel1
..........
class MyPanel1 extends JPanel {

    JTextField JTextfield1 = new JTextField(15), JTextfield2 = new JTextField(15);
    JTextArea Discription = new JTextArea(4,30);

    public MyPanel1() {


        //add components, use THIS to refer to the current JPanel which is MyPanel1
        addItem(this, new JLabel("Sample ID:"), 0, 0, 1, 1, GridBagConstraints.SOUTHWEST);
        addItem(this, new JLabel("User ID:"), 1, 0, 1, 1, GridBagConstraints.SOUTHWEST);
        addItem(this, new JLabel("Bone Description:"), 0, 2, 1, 1, GridBagConstraints.SOUTHWEST);

        addItem(this, JTextfield1, 0, 1, 1, 1, GridBagConstraints.NORTHWEST);
        addItem(this, JTextfield2, 1, 1, 1, 1, GridBagConstraints.NORTHWEST);
        addItem(this, Discription, 0, 3, 1, 1, GridBagConstraints.WEST);

        Icon nextIcon = new ImageIcon("arrow.jpeg");
        JButton nextButton = new JButton("Next", nextIcon);
        addItem(this, nextButton, 1, 4, 1, 1, GridBagConstraints.NORTHEAST);
        nextButton.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            // this gets the CardLayout from Parent of the Panel
            CardLayout cardLayout = (CardLayout) MyPanel1.this.getParent().getLayout();
            cardLayout.show(MyPanel1.this.getParent(), "Panel 2");
        }
    });
}

    public void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    } 
}

class MyPanel2 extends JPanel {

    public MyPanel2() {
        // for testing if Panel 2 shows up
        addItem(this, new JLabel("Panel 2:"), 0, 0, 1, 1, GridBagConstraints.SOUTHWEST);
    }

    public void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);

    }
}