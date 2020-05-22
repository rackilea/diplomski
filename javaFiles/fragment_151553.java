SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        JPanel    panel = new JPanel();
        JCheckBox check = new JCheckBox("Yes or no?");
        panel.add(check);

        JOptionPane.showMessageDialog(null, panel);
        JOptionPane.showMessageDialog(null,
            "You entered " + (check.isSelected() ? "yes" : "no") + "."
        );
    }
});