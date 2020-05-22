final JButton okay = new JButton("Ok");
okay.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane pane = getOptionPane((JComponent)e.getSource());
        pane.setValue(okay);
    }
});
okay.setEnabled(false);
final JButton cancel = new JButton("Cancel");
cancel.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane pane = getOptionPane((JComponent)e.getSource());
        pane.setValue(cancel);
    }
});