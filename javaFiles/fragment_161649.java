JCheckBoxMenuItem checkbox = new JCheckBoxMenuItem("Checkbox");
checkbox.addActionListener((ActionEvent e) -> {
        boolean isCheck = ((JCheckBoxMenuItem)e.getSource()).isSelected();
        if (isCheck) {
            JOptionPane.showMessageDialog(null, "You checked the checkbox", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
});