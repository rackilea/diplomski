javax.swing.Timer timer1 = new javax.swing.Timer(0, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(new Date());
        }
    });

    timer1.setRepeats(true);
    timer1.setDelay(1000);