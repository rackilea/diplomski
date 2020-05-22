public void actionPerformed(ActionEvent e) {
     contentPane.remove(panel);
     panel = new Clients().getContentPane();
     panel.setVisible(true);
     contentPane.add(panel);
     contentPane.repaint();
     contentPane.revalidate();

     }
   });