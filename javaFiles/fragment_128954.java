button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the English they entered
        String text = original.getText();
        text = text.trim();
        text = text.toLowerCase();

        // Display the translation
        translation.setText(englishToPig(text));
    }
});