public void launchJFrame() {

    alert.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //Execute when button is pressed
        }
    });

    yesNo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //Execute when button is pressed
            int val = JOptionPane.showConfirmDialog(null,
                            "Choose yes or no", "Your Call...",
                            JOptionPane.YES_NO_OPTION);

            if (val != JOptionPane.CLOSED_OPTION) {
                if (val == 0) {
                    txt.setText("Yes");
                } else {
                    txt.setText("No");
                }
            }
        }
    });

    color.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //Execute when button is pressed
            Object[] options = {"Red", "Green"};

            int sel = JOptionPane.showOptionDialog(null,
                            "Choose a Color!", "Warning",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE, null,
                            options, options[0]);

            if (sel != JOptionPane.CLOSED_OPTION) {
                txt.setText("Color Selected: " + options[sel]);
            }
        }
    });

    vals.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //Execute when button is pressed
            Object[] selections = {"First", "Second", "Third"};

            Object val = JOptionPane.showInputDialog(null,
                            "Choose one", "Input",
                            JOptionPane.INFORMATION_MESSAGE,
                            null, selections, selections[0]);

            if (val != null) {
                txt.setText(val.toString());
            }
        }
    });

    input.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //Execute when button is pressed
            String val = JOptionPane.showInputDialog("How mant fingers do you see?");

            txt.setText(val);
        }
    });

}