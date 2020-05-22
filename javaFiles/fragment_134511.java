public class VehicleJFrame extends JFrame implements ActionListener
{

private JButton previousButton;
private JButton addButton; //NEW - For adding vehicles
private JButton sellButton;
private JButton nextButton;
private JPanel centerPanel;
private JTextPane displayPane;
private Showroom theShowRoom;


public VehicleJFrame()
{
    super("Vehicle GUI");
    setSize(800, 400);
    setLocation(400, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    createGUI();

    setVisible(true);

}


public void createGUI()
{
    previousButton = new JButton();
    sellButton = new JButton();
    nextButton = new JButton();
    centerPanel = new JPanel();

    //Add code for center panel to display the current vehicle
    previousButton = new JButton("Previous");
    previousButton.addActionListener(this);
    sellButton = new JButton("Sell");
    addButton = new JButton("Add");
    sellButton.addActionListener(this);
    nextButton = new JButton("Next    ");
    nextButton.addActionListener(this);
    addButton.addActionListener(this);
    displayPane = new JTextPane();//NEW - For displaying
    displayPane.setEditable(false);//NEW - Only for display so no editing
    theShowRoom = new Showroom("Showroom 1");//NEW - To store our vehicles in

    getContentPane().setLayout(new BorderLayout(10, 10));
    getContentPane().add(displayPane, BorderLayout.CENTER);//NEW - The place to display cars in the middle
    getContentPane().add(previousButton, BorderLayout.WEST);
    getContentPane().add(sellButton, BorderLayout.SOUTH);
    getContentPane().add(addButton, BorderLayout.NORTH);//NEW - The add button
    getContentPane().add(nextButton, BorderLayout.EAST);

}


@Override
public void actionPerformed(ActionEvent e)
{

    if (e.getSource() == previousButton)
    {

    }
    else if (e.getSource() == sellButton)
    {

    }
    else if (e.getSource() == nextButton)
    {

    }
    else if (e.getSource() == addButton){
        Vehicle v = new Vehicle(JOptionPane.showInputDialog(null, "Manafacturer"),
                JOptionPane.showInputDialog(null, "Model"),
                JOptionPane.showInputDialog(null, "Vin"),
                JOptionPane.showInputDialog(null, "Manafacture date"),
                JOptionPane.showInputDialog(null, "Tax band").charAt(0),
                Integer.valueOf(JOptionPane.showInputDialog(null, "cost")));
        theShowRoom.addVehicle(v);//Add to showroom
        displayPane.setText(theShowRoom.getCurrentVehicle().toString());
      }



}

public static void main(String[] args){ //To test the program
javax.swing.SwingUtilities.invokeLater(new Runnable() {

    @Override
    public void run() {
        new VehicleJFrame();

    }
});
}}