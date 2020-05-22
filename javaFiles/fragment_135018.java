String a1 = jTextField1.getText();
String a2 = jTextField2.getText();
String a3 = jTextField3.getText();
String a4 = jTextField4.getText();
String a5 = jTextField5.getText();

String m1 = "You will never forget " + a1 + "\n\n";
String m2 = "You can consider " + a2 + " as your true friend \n\n";
String m3 = "You really Love " + a3 + "\n\n";
String m4 = a4 + " is your twin soul \n\n" ; 
String m5 = "you will remember " + a5 + " for the rest of your life (due to past –good or bad- experiences, lessons etc) \n\n";
String m6 = m1 + m2 + m3 + m4 + m5;

JLabel label = new JLabel(m6);
label.setFont(new Font("serif", Font.BOLD, 14));
JOptionPane.showMessageDialog(null,label);