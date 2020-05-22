JPanel al = new JPanel();
for (MyClass mc : sr.getFields().values()){
    JCheckBox box = new JCheckBox(mc.getType());
    al.add(box);
}
JOptionPane.showConfirmDialog(null, al);