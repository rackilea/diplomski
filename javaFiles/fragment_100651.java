b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            jl.setText(lines.get(i));
            i++;
            if ( i > lines.size() ) {
                i = 0;
            }
            if (b1.getText().equals("Click For Answer")) {
                b1.setText("Next Question");
            } else {
                b1.setText("Click For Answer");
            }
        }
    });