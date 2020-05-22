JPanel layoutPanel = new JPanel(new GridLayout(genres.length, 1));
for (JCheckBox c : check) {
  layoutPanel.add(c);
}
JScrollPane scroller = new JScrollPane(layoutPanel);
scroller.setPreferredSize(new Dimension(300, 500));
int answer = JOptionPane.showConfirmDialog(null, scroller, "Genres" , JOptionPane.OK_CANCEL_OPTION);