setLayout(new BorderLayout());
JPanel panel = new JPanel();
panel.setLayout(new VerticalLayout()); // this layout is in swingx package
JScrollPane jScrollPane1= new JScrollPane()
jScrollPane1.setViewportView(jList1);
setLayout(new BorderLayout());
panel.add(jScrollPane1);// add to the frame
add(panel);
pack();// Size the frame.