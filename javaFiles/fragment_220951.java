List<JCheckBox> list = new ArrayList<>();
for(disponibility prov: dis){    
   JCheckBox check=new JCheckBox();    
   check.setBounds(30,156,97,33);
   list.add(check);
}
//Later access nth checkbox
list.get(n).setEnabled(true);