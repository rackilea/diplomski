public void actionPerformed(java.awt.event.ActionEvent e) {
     win.setTitle("Thanks, I needed that");
     javax.swing.JButton btn;
     btn = (javax.swing.JButton)e.getSource();
     btn.setText("Thanks, I needed that");

     if (oval.getBackground().equals(java.awt.Color.red))
         oval.setBackground(java.awt.Color.green);
     else if (oval.getBackground().equals(java.awt.Color.green))
         oval.setBackground(java.awt.Color.blue);
     else if (oval.getBackground().equals(java.awt.Color.blue))
         oval.setBackground(java.awt.Color.red);
     win.repaint();
}