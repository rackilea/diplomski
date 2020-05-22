aClass(){

    JFrame jfrm = new JFrame("Example");
    jfrm.setSize(200, 200);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setLayout(new FlowLayout());
    jfrm.setLocationRelativeTo(null);

    JButton jbtn1 = new JButton("Push");
    JButton jbtn2 = new JButton("Click");
    JButton jbtn3 = new JButton("Press");

    jbtn1.addActionListener(this);
    jbtn2.addActionListener(this);
    jbtn3.addActionListener(this);

    jfrm.add(jbtn1);
    jfrm.add(jbtn2);
    jfrm.add(jbtn3);
}

public static String[] buttonNames = {"Push", "Click", "Press"}; // Put button names in an array
public static int[] buttonClicks = {0, 0, 0}; // Set the clicks to default

    public void actionPerformed(ActionEvent ae)
            {
                 for(int i = 0; i < buttons.length; i++){
                    if(ae.getActionCommand().equals(buttonNames[i])){
                    buttonClicks[i] =  buttonClicks[i] + 1; // Record the clicks. I think you can use buttonClicks[i]++, but I'm not sure
                    }
                 }
            }