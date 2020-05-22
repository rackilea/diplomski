ab.addActionListener(
    new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            a = JColorChooser.showDialog(null, "Pick a Color", a);
            x = 2;
            repaint();
        }
    }
);
bb = new JButton("Choose your second Rectangle color");
bb.addActionListener(
    new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            b = JColorChooser.showDialog(null, "Pick a Color", b);
            y = 2;
            repaint();
        }
    }
);