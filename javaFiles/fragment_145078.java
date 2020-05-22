public class CarGUI extends JPanel {

private CarTaxManager manager;
private JLabel lpLabel;
private JTextField searchField;
private JButton searchButton;

public CarGUI(){
    setLayout(new BorderLayout());

    JPanel north = new JPanel();
    north .setLayout(new FlowLayout());
    lpLabel = new JLabel("License Plate");
    searchField = new JTextField(10);
    searchButton = new JButton("Search");
    north.add(lpLabel);
    north.add(searchField);
    north.add(searchButton);
    add(north, BorderLayout.NORTH);


    JPanel center = new JPanel();
    center.setLayout(new FlowLayout());
    //TODO add components to center
    add(center, BorderLayout.CENTER);

    JPanel south= new JPanel();
    south.setLayout(new FlowLayout());
    //TODO add components to south
    add(south, BorderLayout.SOUTH);

}