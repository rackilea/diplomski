public class Directory {
  public static void main(String args[]) throws IOException {

    JFrame frame = new JFrame("Directory");
    frame.setPreferredSize(new Dimension(300, 300));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JProgressBar searchprogress = new JProgressBar();
    JPanel panel = new JPanel();
    final JButton searchbutton = new JButton("Search");
    final JTextField searchfield = new JTextField();
    searchfield.setPreferredSize(new Dimension(100, 30));
    searchprogress.setPreferredSize(new Dimension(200, 30));
    searchbutton.setLocation(100, 100);

    /* Start Buffered Reader */
    final List<String> housetypes = new ArrayList<String>();
    String line = "";
    BufferedReader br = new BufferedReader(new FileReader("test1.txt"));
    while (line != null) {
        line = br.readLine();
        housetypes.add(line);
        String housenumber = br.readLine();
        String housestreet = br.readLine();
        String housepostal = br.readLine();
        String houseplace = br.readLine();
        String seperation = br.readLine();
    }
    /* Finish Buffered Reader */

    /* Start Content Code */
    JButton done = new JButton("Done");
    done.setVisible(false);
    JLabel housetype_label = new JLabel();
    JLabel housenumber_label = new JLabel();
    JLabel housestreet_label = new JLabel();
    JLabel housepostal_label = new JLabel();
    JLabel houseplace_label = new JLabel();

    /* Finish Content Code */

    /* Start Button Code */
    searchbutton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            String searchquery = searchfield.getText();
            searchprogress.setValue(100);
            searchfield.setEnabled(false);
            for (String housetype : housetypes) {
                if (searchquery.equals(housetype)) {
                    System.out.println("We Have Found  A Record!!");
                }
            }
        }
    });

    /* Finish Button Code */
    /* Test Field */

    /* End Test Field */

    panel.add(searchfield);
    panel.add(done);
    panel.add(searchbutton);
    panel.add(searchprogress);
    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}