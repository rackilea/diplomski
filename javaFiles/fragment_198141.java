Map<Integer,JCheckBox> map = new HashMap<Integer,JCheckBox>();
for (j=0;j<j1;j++){
   final JCheckBox cb = new JCheckBox("");
   cb.setText(col_name);
   mainPanel12.add(cb,BorderLayout.NORTH);
   mainPanel12.repaint();
   map.put(j,cb);
...
}