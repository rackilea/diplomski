close.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            this.value = "This is Result";
            setVisible(false);
            owner.childActionPerformed(e);
        }
    });