btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        // delay between timer ticks: 1000
        int timerDelay = 1000;
        new Timer(timerDelay, new ActionListener() {
            private int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                // timer's stopping condition
                if (counter >= MAX_VALUE) { // MAX_VALUE is a constant int = 5
                    ((Timer) e.getSource()).stop();
                } else {
                    textArea.append("Value " + counter + "\n");
                }
                counter++; // increment timer's counter variable
            }
        }).start();
    }
});