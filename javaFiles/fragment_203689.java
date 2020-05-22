for (int i = 0; i < 16; i++) {
    JButton button = new JButton("Button: " + i);
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("you clicked me!");
        }
    });
    frame.add(button);
}