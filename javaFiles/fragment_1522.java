JLabel labelSingleClick = new JLabel("Single click me.");
    JLabel labelDoubleClick = new JLabel("Double click me.");
    labelSingleClick.addMouseListener(new MouseLiberalAdapter() {
        @Override
        public void mouseLiberalClick(MouseEvent e) {
            JOptionPane.showMessageDialog(null, "Single click detected.");
        }
    });
    labelDoubleClick.addMouseListener(new MouseLiberalAdapter() {
        @Override
        public void mouseLiberalDoubleClick(MouseEvent e) {
            JOptionPane.showMessageDialog(null, "Double click detected.");
        }
    });