ArrayList<JCheckBox> al = new ArrayList<JCheckBox>();
for (MyClass mc : sr.getFields().values()){
    JCheckBox box = new JCheckBox(mc.getType());
    al.add(box);
}
Object[] obj = (Object[]) al.toArray(new Object[al.size()]);
JOptionPane.showConfirmDialog(ui, obj);