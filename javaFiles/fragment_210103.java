private void createEvents() {
    rdbtnOne.addActionListener(new ActionListener() {
        // ****** A *****
        public void actionPerformed(ActionEvent e) {
            // ***** B ****
            rdbtnOne.addActionListener(new ButtonTester());
        }
    });
}