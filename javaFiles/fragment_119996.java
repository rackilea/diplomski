final JFrame frame = new JFrame();
    final JLabel label1 = new JLabel("Label 1");
    final JLabel label2 = new JLabel("Label 2");
    final JTextField textField = new JTextField();
    MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            textField.setText(((JLabel) e.getSource()).getText());
        }

    };
    label1.addMouseListener(mouseListener);
    label2.addMouseListener(mouseListener);
    frame.add(label1, BorderLayout.NORTH);
    frame.add(label2, BorderLayout.CENTER);
    frame.add(textField, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);