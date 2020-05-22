public class Main implements ActionListener{

    JFrame f;
    JButton button;

    boolean TP_B = false;

    ButtonBehaviour bb;

    public Main()
    {
        bb = new ButtonBehaviour(this);
        f = new JFrame();

        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Test");

        button.addActionListener(this);
        f.add(button);


        f.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
        {
            System.out.println("Call the specific function in your behaviour class");
            bb.buttonBehaviour();
        }

    }


}

class ButtonBehaviour{

    Main m;

    public ButtonBehaviour(Main pMain)
    {
        m = pMain;
    }

    public void buttonBehaviour()
    {
         System.out.println("TP");

         m.TP_B = true;

         //Write here your rest behaviour.
         //Keep in mind to use your Main instance or Frame instance
         //for calling and changing your specific variables.
         //you could also just create your
         //buttonBehaviour-Functions in your Frame class. Would
         //be easier
    }
}