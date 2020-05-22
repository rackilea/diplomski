public class ButtonGrid implements ActionListener, KeyListener{

    JFrame frame=new JFrame(); 
    JButton[] grid; // grid field remains null

    public ButtonGrid(){ 
            frame.setTitle("MPC");
            frame.setLayout(new GridBagLayout()); 
            JButton[] grid=new JButton[12]; //  ****** a LOCAL variable ******