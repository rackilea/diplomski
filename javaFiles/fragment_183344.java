JTable jtable = new JTable();
//...
JScrollPane sc = new JScrollPane(jtable);
//sc.setViewportView(jtable); <- This way is correct too
//
getContentPane().add(sc);