public class gui extends JFrame implements ActionListener, FocusListener {

    //put searchText here
    JTextField searchText;


    public gui() {
        super("Project 2.0 Indev");
        setLookAndFeel();
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon search = new ImageIcon("C:/Users/User/Documents/searchicon.png");
    JButton searchButton = new JButton(search);
    searchText = new JTextField("Search...");
    searchText.addFocusListener(this);
    searchText.setColumns(15);