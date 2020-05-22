JTextPane tp = new JTextPane();
JScrollPane js = new JScrollPane();
js.getViewport().add(tp);
JFrame jf = new JFrame();
jf.getContentPane().add(js);
jf.pack();
jf.setSize(800,800);
jf.setVisible(true); 

try {
  URL url = new URL("http://www.google.com");
  tp.setPage(url);
} 
catch (Exception e) {
  e.printStackTrace();
}