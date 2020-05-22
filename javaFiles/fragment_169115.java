Object source = e.getSource();
if (source == alert) {
    JOptionPane.showMessageDialog(null,
                    "There's a bug on you!", "Hey!",
                    JOptionPane.ERROR_MESSAGE);
} else if (...