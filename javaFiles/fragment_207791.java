public class addclassroom extends JFrame {

    public JTextField txt_classno, txt_bname, txt_size, txt_resources;
    public JComboBox cmbfloor;
    public JLabel label1, label2, label3, label4, label5, label6;
    public JButton Save;
    public JButton Reset;
    public JButton Back;
    JFrame ciFrame = new JFrame("Classroom Records Input Form");

    public addclassroom() {

        label1 = new javax.swing.JLabel();
        label1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        label1.setForeground(Color.BLACK);
        label1.setText("Classroom Records Input");

        label2 = new javax.swing.JLabel("Classroom_No:");
        txt_classno = new javax.swing.JTextField(8);

        label3 = new javax.swing.JLabel("Building Name:");
        txt_bname = new javax.swing.JTextField(15);

        label4 = new javax.swing.JLabel("Building Floor:");
        String floor[] = { "Ground floor", "1st floor", "2nd floor", "3rd floor", "4th floor", "5th floor",
                "6th floor", "7th floor", "8th floor" };
        cmbfloor = new javax.swing.JComboBox(floor);

        label5 = new javax.swing.JLabel("Size Capacity:");
        txt_size = new javax.swing.JTextField(5);

        label6 = new javax.swing.JLabel("Resources");
        txt_resources = new javax.swing.JTextField(20);

        Save = new javax.swing.JButton();
        Save.setText("Save");

        Reset = new javax.swing.JButton();
        Reset.setText("Reset");

        Back = new javax.swing.JButton();
        Back.setText("Back");

        label1.setBounds(100, 25, 200, 50);

        label2.setBounds(50, 100, 100, 50);
        txt_classno.setBounds(180, 100, 100, 30);

        label3.setBounds(50, 150, 100, 50);
        txt_bname.setBounds(180, 150, 140, 30);

        label4.setBounds(50, 200, 100, 50);
        cmbfloor.setBounds(180, 200, 115, 30);

        label5.setBounds(50, 250, 100, 50);
        txt_size.setBounds(180, 250, 65, 30);

        label6.setBounds(50, 300, 100, 50);
        txt_resources.setBounds(180, 300, 175, 30);

        Save.setBounds(100, 400, 75, 20);
        Reset.setBounds(200, 400, 75, 20);
        Back.setBounds(300, 400, 75, 20);


        ciFrame.add(label1);
        ciFrame.add(label2);
        ciFrame.add(txt_classno);
        ciFrame.add(label3);
        ciFrame.add(txt_bname);
        ciFrame.add(label4);
        ciFrame.add(cmbfloor);
        ciFrame.add(label5);
        ciFrame.add(txt_size);
        ciFrame.add(label6);
        ciFrame.add(txt_resources);

        ciFrame.add(Save);

        ciFrame.add(Reset);
        ciFrame.add(Back);

        ciFrame.setLayout(null);

        ciFrame.setVisible(true);

        ciFrame.setSize(500, 500);

        ciFrame.setResizable(false);

        ciFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Save.setMnemonic('S');
        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Save.setEnabled(true);
            }
        });

        Reset.setMnemonic('R');
        Back.setMnemonic('B');

        Handleraddclassroom h = new Handleraddclassroom();
        Save.addActionListener(h);
        Reset.addActionListener(h);
        Back.addActionListener(h);

    }

    public static void main(String[] args) {
        new addclassroom();
    }

    public class Handleraddclassroom implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String name = ((JButton) event.getSource()).getText();

            if (name.equals("Back")) {
                ciFrame.dispose();
//                Classroomdetails cm = new Classroomdetails();

            }

            if (name.equals("Reset")) {

                txt_classno.setText("");
                txt_bname.setText("");
                txt_size.setText("");
                txt_resources.setText("");

            }

            if (name.equals("Save")) {
                String filename = "C:/JAVA/schedule.accdb";
                String database = "jdbc:odbc:scheduling";

                // Character & Presence checks

                String nsize = txt_size.getText();
                String rsc = txt_resources.getText();

                Pattern p = Pattern.compile("[A-Z,a-z,&%$@!()*^]");
                Matcher Cnsize = p.matcher(nsize);

                Pattern q = Pattern.compile("[A-Z,a-z,&%$@!()*^]");
                Matcher Rsc = q.matcher(rsc);

                if (txt_classno.getText().equals("")) {
                    JOptionPane.showMessageDialog(addclassroom.this, "Classroom No field should not be blank");

                }

                if (txt_bname.getText().equals("")) {
                    JOptionPane.showMessageDialog(addclassroom.this, "Building Name field should not be blank");

                }

                if (txt_size.getText().equals("")) {
                    JOptionPane.showMessageDialog(addclassroom.this, "Size Capacity field should not be blank");

                } else if (Cnsize.find()) {
                    JOptionPane.showMessageDialog(addclassroom.this,
                            "Invalid value for Size capacity entered. Please check again");

                }

                if (txt_resources.getText().equals("")) {
                    JOptionPane.showMessageDialog(addclassroom.this, "Resources field should not be blank");

                } else if (!Rsc.find()) {
                    JOptionPane.showMessageDialog(addclassroom.this,
                            "Invalid value for Resources entered. Please check again");
                }

                else {
                    try {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

                        Connection con = DriverManager.getConnection(database, "", ""); // username
                                                                                        // &password
                                                                                        // not
                                                                                        // being
                                                                                        // used

                        String flr = "";
                        if (cmbfloor.getSelectedIndex() == 0) {
                            flr = "Ground floor";
                        } else if (cmbfloor.getSelectedIndex() == 1) {
                            flr = "1st floor";
                        }

                        else if (cmbfloor.getSelectedIndex() == 2) {
                            flr = "2nd floor";
                        } else if (cmbfloor.getSelectedIndex() == 3) {
                            flr = "3rd floor";
                        } else if (cmbfloor.getSelectedIndex() == 4) {
                            flr = "4th floor";
                        } else if (cmbfloor.getSelectedIndex() == 5) {
                            flr = "5th floor";
                        } else if (cmbfloor.getSelectedIndex() == 6) {
                            flr = "6th floor";
                        } else if (cmbfloor.getSelectedIndex() == 7) {
                            flr = "7th floor";
                        } else if (cmbfloor.getSelectedIndex() == 8) {
                            flr = "8th floor";
                        }

                        Statement s = con
                                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // The
                                                                                                                 // Result
                                                                                                                 // set
                                                                                                                 // can
                                                                                                                 // now
                                                                                                                 // scroll
                                                                                                                 // forward
                                                                                                                 // and
                                                                                                                 // back

                        String sql = "INSERT INTO classroom VALUES('"

                        + txt_classno.getText() + "','" + txt_bname.getText() + "','"

                        + flr + "','" + txt_size.getText() + "','" + txt_resources.getText() + "' )";

                        JOptionPane.showMessageDialog(addclassroom.this, "Classroom Records Saved.");
                        dispose();

                        addclassroom ac = new addclassroom();

                        s.execute(sql);

                        s.close();
                        con.close();

                    } catch (Exception e) {
                        System.out.print("Error: " + e);
                    }
                }
            }
        }

    }

}