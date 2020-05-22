public class Demo {

    private JPanel content;
    private JFrame frame;

    private void createAndShowGUI() {        
        content = new JPanel(new GridBagLayout());

        SwingWorker<Void, Data> worker = new SwingWorker<Void, Data>() {
            @Override
            protected Void doInBackground() {                    
                try{
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
                   Statement stat = con.createStatement();
                   ResultSet rs = stat.executeQuery("select * from TableName");
                   while(rs.next()){
                      String componentType = rs.getString("component");
                      int column = rs.getInt("x");
                      int row = rs.getInt("y");
                      int width = rs.getInt("width");
                      int height = rs.getInt("height");
                      int weightx = rs.getInt("weightx");
                      int weighty = rs.getInt("weighty");
                      String text = rs.getString("text");
                      Data data = new Data(componentType, column, row, width, height
                                          ,weightx, weighty, text);
                      publish(data);
                  }
                  rs.close();
                  stat.close();
                  con.close();
              } catch(Exception e) {
                  System.out.println(e);
              }

                return null;
            }

            @Override
            protected void process(List<Data> chunks) {
                for(Data data : chunks) {

                    JComponent component = null;
                    if(data.getComponentType().equalsIgnoreCase("JTextField")) {
                        component = new JTextField(data.getText());
                    }

                    if(data.getComponentType().equalsIgnoreCase("JComboBox")) {
                        component = new JComboBox();
                    }

                    if(data.getComponentType().equalsIgnoreCase("JLabel")) {
                        component = new JLabel(data.getText());
                    }

                    if(component != null) {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = data.getColumn();
                        constraints.gridy = data.getRow();
                        constraints.gridwidth = data.getWidth();
                        constraints.gridheight = data.getHeight();
                        constraints.weightx = data.getWeightX();
                        constraints.weighty = data.getWeightY();

                        constraints.anchor = GridBagConstraints.WEST;
                        constraints.fill = GridBagConstraints.BOTH;
                        constraints.insets = new Insets(8,8,8,8);
                        content.add(component, constraints);
                    }

                }
            }

            @Override
            protected void done() {
                frame = new JFrame("Demo");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(content);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        };

        worker.execute();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGUI();
            }
        });
    }
}