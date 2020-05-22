public class GUI extends JFrame {

    JButton button2;
    JTextArea textArea;

    public GUI() {
        super("Yarra Tram Route Finder");
    }

    public void routeList() {

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "YarraTram";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "abc123";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);

            PreparedStatement statement = conn.prepareStatement("Select rid,route from route");
            ResultSet result = statement.executeQuery();

            StringBuilder strBuilder = new StringBuilder();
            while (result.next()) {
                strBuilder.append(result.getString(1)).append(" ").append(result.getString(2));
                strBuilder.append("\n");

            }
            textArea.setText(strBuilder.toString());
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAndShowGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        button2 = new JButton("Route");
        textArea = new JTextArea(20, 20);
        add(textArea);
        add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                routeList();
            }
        });
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.createAndShowGUI();
            }
        });
    }
}