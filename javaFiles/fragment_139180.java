String[] columnNames = {"Date","Field", "Home Team","Visitor Team", "Score"};
JFrame guiFrame = new JFrame(); //no layout specified, frames use BorderLayout by default
guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
guiFrame.setTitle("Soccer Schedule");
guiFrame.setSize(500,500);
guiFrame.setLocationRelativeTo(null);

JPanel panel = new JPanel(new BorderLayout());
panel.setSize(450, 450);
JLabel titleLabel = new JLabel("Real Tired");

//String[][] data = createTableContents(scheduleCsv);

//my test data
String[][] data = new String[1][5];
for (int i = 0; i < 5; ++i)
{
    data[0][i] = "cell " + i;
}

JTable scheduleTable = new JTable(data,columnNames);
JScrollPane scrollPane = new JScrollPane(scheduleTable);
panel.add(titleLabel, BorderLayout.NORTH);
panel.add(scrollPane, BorderLayout.CENTER);

guiFrame.add(panel); //this is actually  guiFrame.add(panel, BorderLayout.CENTER);
guiFrame.setVisible(true);