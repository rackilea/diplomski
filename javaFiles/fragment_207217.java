loginB.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char[] pass = passwordText.getPassword();
            System.out.println(pass);
        }
    });