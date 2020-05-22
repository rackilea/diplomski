panel.add(new JButton(new AbstractAction("Push Me 2 -- Using Dialog") {
    @Override
    public void actionPerformed(ActionEvent e) {
        // button that when pressed, closes the JDialog that holds it
        // similar to a JOptionPane's OK button
        JButton disposeWinBtn = new JButton(new DisposeWindowAction("OK", KeyEvent.VK_O));

        // create a bunch of JPanels, add components to them, ...
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(disposeWinBtn);

        JLabel msgLabel = new JLabel("My Message");
        JPanel msgPanel = new JPanel();
        msgPanel.add(msgLabel);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(msgPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.PAGE_END);

        // create a JDialog whose parent component is the main JFrame
        // and make sure that it is *****non-modal ***** <===== this is KEY *****
        JDialog dialog = new JDialog(frame, "Dialog", ModalityType.MODELESS);
        dialog.add(panel);  // add the JPanel, panel, created above, with components
        dialog.pack();  // have layout managers do their thing
        dialog.setLocationRelativeTo(frame); // center it over the main JFrame
        dialog.setVisible(true);  // and display it
    }
}));