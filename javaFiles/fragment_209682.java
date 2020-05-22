JRadioButton family = new JRadioButton();
// do any other thing you want to do to this button and finally..
family.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            familyActionPerformed(evt);
        }
    });

JButton submit = new JButton("Submit");
submit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            submitActionPerformed(evt);
        }
    });