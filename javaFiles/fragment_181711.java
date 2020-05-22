public static void main(String args[]){
JFrame f = new JFrame();
f.setLayout(new BorderLayout());
final JPanel p = new JPanel();
p.add(new JLabel("A Panel"));
f.add(p, BorderLayout.CENTER);