Timer timer = new Timer(time, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
        }
    });
    timer.start();