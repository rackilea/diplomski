@Override
    public void actionPerformed(ActionEvent e) {

        // finds which button was clicked
        JButton buttonClicked = (JButton) e.getSource();

        restartGame = false;
        restart.setVisible(false);

        // sets up gold array
        Boolean[] randomGold = new Boolean[144];

        // fills gold array with 10 true elements
        for (int i = 0; i < randomGold.length; i++) {
            randomGold[i] = false;

            // sets 10 indexes in the array to true
            if (i == 10 || i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80 || i == 90 || i == 100) {
                randomGold[i] = true;
            }
        }

        // randomizes gold array
        Collections.shuffle(Arrays.asList(randomGold));