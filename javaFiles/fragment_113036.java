final JList list = new JList(Locale.getAvailableLocales());
final JPopupMenu popup = new JPopupMenu();
popup.add(new JScrollPane(list));
popup.setFocusable(false);
final JTextField field = new JTextField(20);
Action down = new AbstractAction("nextElement") {

    @Override
    public void actionPerformed(ActionEvent e) {
       int next = Math.min(list.getSelectedIndex() + 1,
               list.getModel().getSize() - 1);
       list.setSelectedIndex(next);
       list.ensureIndexIsVisible(next);
    }
};
field.getActionMap().put("nextElement", down);
field.getInputMap().put(
        KeyStroke.getKeyStroke("DOWN"), "nextElement");