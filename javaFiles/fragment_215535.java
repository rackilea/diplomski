final JButton button = new JButton("Save");
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {                                          
        // Take somehow care of multiple clicks
        button.setText("Saving...");
        final Timer t = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                button.setText("Saved");
            }
        });
        t.setRepeats(false);
        t.start();
    }
});