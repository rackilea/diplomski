public class TablePanel
{
  public static void addTableToPanel(JPanel jPanel, Vector rowData, Vector columnNames)
  {
    JTable jTable = new JTable(rowData, columnNames);
    jTable.setFillsViewportHeight(true);

    JScrollPane jScrollPane = new JScrollPane(jTable);
    jScrollPane.setPreferredSize(new Dimension(300, 50));

    jPanel.add(jScrollPane);
  }

  public static void main(String[] args) throws Exception
  {
    SwingUtilities.invokeAndWait(new Runnable()
    {
      @Override
      public void run()
      {
        Vector cols = new Vector();
        Vector rows = new Vector();
        Vector row1 = new Vector();

        cols.add("A");
        cols.add("B");
        cols.add("C");
        row1.add("1");
        row1.add("2");
        row1.add("3");
        rows.add(row1);
        rows.add(row1.clone());
        rows.add(row1.clone());
        rows.add(row1.clone());

        JFrame frame = new JFrame("TableTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout(0, 0));
        TablePanel.addTableToPanel(jPanel, rows, cols);

        frame.getContentPane().add(jPanel);
        frame.pack();
        frame.setVisible(true);
      }
    });
  }
}