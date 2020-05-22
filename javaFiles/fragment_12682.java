public class ButtonGrid implements ActionListener, KeyListener{

    JFrame frame = new JFrame(); 
    JButton[] grid; 

    public ButtonGrid(){
            frame.setTitle("MPC");
            frame.setLayout(new GridBagLayout()); 
            grid = new JButton[12]; //  ***** this initializes the field ******