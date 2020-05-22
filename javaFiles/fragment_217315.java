JButton btn = new JButton("add");
    btn.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            model.addElement(new Product("Auto", 10, 3500.50));
        }
    });