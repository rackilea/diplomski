I have given the example



 public static void main(String args[]) {
            String title = (args.length == 0 ? "CheckBox Sample" : args[0]);
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel(new GridLayout(0, 1));
            Border border = BorderFactory.createTitledBorder("Test");
            panel.setBorder(border);

            javax.swing.JCheckBox[] jCheckboxArray;
            //

            int CheckBoxNumber = 5;
            jCheckboxArray = new javax.swing.JCheckBox[CheckBoxNumber];
            for(int x = 0; x < CheckBoxNumber ; x++) {
                jCheckboxArray[x] = new javax.swing.JCheckBox();
                jCheckboxArray[x].setText("CheckBox " + x);
                panel.add(jCheckboxArray[x]);
            }


            Container contentPane = frame.getContentPane();
            contentPane.add(panel, BorderLayout.CENTER);
           // contentPane.add(button, BorderLayout.SOUTH);
            frame.setSize(300, 200);
            frame.setVisible(true);
          }