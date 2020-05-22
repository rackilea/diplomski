JScrollPane jScrollPane1= new JScrollPane()
jScrollPane1.setViewportView(jList1);
getContentPane().setLayout(null);// here u specify layout put the layout what u want
getContentPane().add(jScrollPane1);// add to the contentPane
jScrollPane1.setBounds(126, 63, 100, 100);// here we set coordinates x, y width height cause we have null layout
pack();// Size the frame.