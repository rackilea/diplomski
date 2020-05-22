JPanel contentPane = (JPanel) frame.getContentPane();

contentPane.removeAll();
contentPane.add(panel);
contentPane.revalidate(); 
contentPane.repaint();