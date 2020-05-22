JFrame frame = new JFrame("SIMPLE TEXT");
JPanel panel = new JPanel();
JTextArea textarea = new JTextArea();
JPanel footer = new JPanel();       
JLabel linecol = new JLabel("line: 0 col: 0");

//frame.setSize(640,480);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//frame.setLocationRelativeTo(null);
//frame.setVisible(true);
//frame.setResizable(false);

//...

frame.add(panel);
panel.add(footer, BorderLayout.PAGE_END);
panel.add(textarea);
footer.add(linecol, BorderLayout.LINE_END);

frame.setResizable(false);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);