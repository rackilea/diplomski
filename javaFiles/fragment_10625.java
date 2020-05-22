// set first jlabel text here

    ActionListener task = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("This is on the EDT after 5 seconds, " +
                "well depending on if I'm used with a Timer, and if " +
                "the right options are set to that Timer");
            // set second jlabel text here
        }
        };
    Timer timer = new Timer(5000 , task);
    timer.setRepeats(false);
    timer.start();