DefaultListModel model = new DefaultListModel();
for(GregorianCalendar g : futureDates) {
    String m = months[g.get(Calendar.MONTH)];
    String d = String.valueOf(g.get(Calendar.DAY_OF_MONTH));
    model.addElement(m + " " + d);
}
JList jlist = new JList(model);

JOptionPane.showMessageDialog(null,jlist);

JOptionPane.showMessageDialog(null,jlist.getSelectedValue());