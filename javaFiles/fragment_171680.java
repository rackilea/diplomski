public class MyWindow extends JFrame {
    private JPanel panelContainer;
    private JLabel lblFirstLabel;
    private JButton btnFirstButton;

    public MyWindow(){

        super("My first window"); //Sets the title
        this.panelContainer = new JPanel(new FlowLayout()) //Has FlowLayout by default but added it anyway
        this.lblFirstLabel = new JLabel("My First Label"); 
        this.btnFirstButton = new JButton("My First Button"); 
        panelContainer.add(lblFirstLabel); //Adds Label to Panel
        panelContainer.add(btnFirstButton); //Adds button to panel
        this.add(panelContainer); //Adds Panel with all comps to frame
        this.pack();
    }

    public static void main(String[] args){
        new MyWindow().setVisible(true);
    }
}