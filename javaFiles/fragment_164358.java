if (needsMessage()) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JOptionPane.showMessageDialog(null, "Not found: " +
                    newValue + ".", "Warning",
                    JOptionPane.WARNING_MESSAGE);

        }
    });
}