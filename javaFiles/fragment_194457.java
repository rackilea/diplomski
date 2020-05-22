public class ChangeButtonLabel {
   private JTextField text1;
   private JButton button;
   private ArrayList Table;
   private JTextField text2;
   private Object[] columnNames;
   private DefaultTableModel model;
   private JTable dataTable;

   public ChangeButtonLabel() {
      JFrame f = new JFrame();
      f.setLayout(null);
      JLabel lab1 = new JLabel("Name");
      JLabel lab2 = new JLabel("Age");
      // table=new JTable(model);

      text1 = new JTextField(20);
      text2 = new JTextField(20);
      button = new JButton("OK");
      lab1.setBounds(10, 10, 100, 20);
      text1.setBounds(120, 10, 100, 20);
      lab2.setBounds(10, 40, 100, 20);
      text2.setBounds(120, 40, 100, 20);

      Table = new ArrayList();
      Table.add(new ArrayList());
      ((ArrayList) Table.get(0)).add("\nProgram Name   ");
      ((ArrayList) Table.get(0)).add("Count   ");
      ((ArrayList) Table.get(0)).add("Elapsed Time   ");
      ((ArrayList) Table.get(0)).add("Average ET\n");

      button.setBounds(120, 100, 100, 20);
      button.addActionListener(new MyAction());

      Object[][] data = { { "Program Name", "count", "ET", "Avg ET" } };
      model = new DefaultTableModel(data, columnNames);
      dataTable = new JTable(model);
      dataTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
      dataTable.setFillsViewportHeight(true);
      dataTable.setBounds(220, 130, 300, 200);

      f.add(lab1);
      f.add(text1);
      f.add(lab2);
      f.add(text2);
      f.add(dataTable);
      f.add(button);
      f.setVisible(true);
      f.setSize(300, 350);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}