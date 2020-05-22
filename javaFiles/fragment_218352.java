this.timer = new Timer(100, new ActionListener() {
    private int sequence = 0;
    public void actionPerformed(ActionEvent evt) {
        if (sequence % 2 == 0) {
            lights[1].setBackground(Color.black);
            lights[3].setBackground(Color.black);
            lights[5].setBackground(Color.black);
            lights[7].setBackground(Color.black);
            lights[sequence].setBackground(Color.green);
        } else {
            lights[0].setBackground(Color.black);
            lights[2].setBackground(Color.black);
            lights[4].setBackground(Color.black);
            lights[6].setBackground(Color.black);
            lights[sequence].setBackground(Color.green);
        }

        sequence++;
        if (sequence > 7) {
            // This seems to be important...?
        }
    }
});