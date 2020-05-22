public class CompileDataJob extends JFrame {
    final boolean DEBUG = false;
  private final JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
          public void run() {
              try {
                  CompileDataJob frame = new CompileDataJob();
                  frame.setVisible(true);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      });
  }

  /**
   * Create the frame.
   */
  public CompileDataJob() {
      setTitle("Inserisci i parametri dei lavori");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 551, 293);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);

      JPanel panel_1 = new JPanel();
      final JTable table = new JTable(new MyTableModel());

      JButton add = new JButton(" ADD ");
      add.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            ((MyTableModel)table.getModel()).addRow(new Job(0, ""));
        }
      });

      JButton btnNewButton = new JButton("    OK   ");
      btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              try{
                      DataJobManager.saveListaLavori(((MyTableModel)table.getModel()).getJobs());
                      CompileDataJob.this.dispose();
                      JOptionPane.showMessageDialog(CompileDataJob.this,"Data Saved");
              }catch(Exception ecc){
                  JOptionPane.showMessageDialog(CompileDataJob.this,"Error during the saving.");
              }
          }
      });
      panel_1.add(btnNewButton);
      panel_1.add(add);
      JButton btnNewButton_1 = new JButton("Cancel");
      btnNewButton_1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
              CompileDataJob.this.dispose();
          }
      });

      JPanel panel = new JPanel();



//      table.setDefaultEditor(Object.class,new MyEditor());

      table.setPreferredScrollableViewportSize(new Dimension(500, 70));
      table.setFillsViewportHeight(true);

              //Create the scroll pane and add the table to it.
              JScrollPane scrollPane = new JScrollPane(table);


      panel_1.add(btnNewButton_1);
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
          gl_contentPane.createParallelGroup(Alignment.LEADING)
              .addGroup(gl_contentPane.createSequentialGroup()
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                      .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      .addComponent(panel, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
                  .addContainerGap())
      );
      gl_contentPane.setVerticalGroup(
          gl_contentPane.createParallelGroup(Alignment.LEADING)
              .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(panel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                  .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      );
      GroupLayout gl_panel = new GroupLayout(panel);
      gl_panel.setHorizontalGroup(
          gl_panel.createParallelGroup(Alignment.LEADING)
              .addGroup(gl_panel.createSequentialGroup()
                  .addGap(11)
                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addContainerGap(12, Short.MAX_VALUE))
      );
      gl_panel.setVerticalGroup(
          gl_panel.createParallelGroup(Alignment.LEADING)
              .addGroup(gl_panel.createSequentialGroup()
                  .addGap(5)
                  .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                  .addContainerGap())
      );
      panel.setLayout(gl_panel);
      contentPane.setLayout(gl_contentPane);



  }
}