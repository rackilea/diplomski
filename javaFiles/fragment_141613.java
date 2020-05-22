final JButton pause = new JButton("Pause");
final JButton unpause = new JButton("Unpause");
    pause.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            try {
                Url.pauseThread();
                pause.setEnabled(false); //this works
                unpause.setEnabled(true); //this does NOT work - "not resolved"

            } catch (InterruptedException e1) {

                e1.printStackTrace();
            }  

        }
    });



    unpause.addActionListener (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                Url.resumeThread();
                pause.setEnabled(true); // this works
                unpause.setEnabled(false); // this works
            } catch (InterruptedException e1) {

                e1.printStackTrace();
            }
        }
    });