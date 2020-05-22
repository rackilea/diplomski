JButton but = new JButton();
    JButton but2 = new JButton();

    but.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            but2.doClick();
        }
    });

    but2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("It works !");
        }
    });