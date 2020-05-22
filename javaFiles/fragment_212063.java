play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            start();
            songTitle.setText("LOVE THE SONG");
            count++;
            amountClicks.setText("You have pressed button " + count + " times.");

            if (countTotal >= 5) {
                warning.setText("MAYBE YOU'VE HAD TOO MUCH!!!");
            } else if (countTotal >= 10) {
                warning.setText("YOU HAVE HAD WAYYY TO MUCH!!!");
            } else {
                warning.setText("WOW!!!");
            }
        }
});