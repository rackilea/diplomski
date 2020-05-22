btn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                // @Override
                public void run() {
                    count++;
                    if (count >= 6) {
                        timer.cancel();
                        timer.purge();

                        // We set the label to done only when the counter
                        // reaches the value 6, after button displayed 5
                        lbl.setText("done");

                        return;
                    }
                    lbl.setText(String.valueOf(count));
                }
            }, 1000,1000);
        }});