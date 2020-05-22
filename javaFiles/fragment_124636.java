JEditorPane jep = new JEditorPane();
jep.setEditable(false);   

try {
  jep.setPage("http://www.yoursite.com");
}catch (IOException e) {
  jep.setContentType("text/html");
  jep.setText("<html>Could not load</html>");
} 

JScrollPane scrollPane = new JScrollPane(jep);     
JFrame f = new JFrame("Test HTML");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.getContentPane().add(scrollPane);
f.setPreferredSize(new Dimension(800,600));
f.setVisible(true);