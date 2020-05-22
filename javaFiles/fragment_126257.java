javax.swing.JFrame openFileFrame = new javax.swing.JFrame();        
openFileFrame.setLayout(new BorderLayout());
openFileFrame.setLocationRelativeTo(null);
openFileFrame.add(openFileChooser, BorderLayout.CENTER);
openFileFrame.pack();
openFileFrame.setVisible(true);