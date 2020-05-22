public class Calculator extends DialogProgram implements ActionListener{ 

    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bm,bd,ba,bs,bdec,bc;
    DoubleField screen;
    JPanel P, P1, P2;

    public void init() { 
        P= new JPanel();     // main panel 
        P1= new JPanel();    // panel for buttons 
        P2= new JPanel();    // panel for screen
        // continue setting up the rest of the GUI...
    }

    public void actionPerformed (ActionEvent e) {
         String clicked = e.getActionCommand();
         if (clicked.equals("ba")) {
             screen.setText("+");
         }
    }   
}