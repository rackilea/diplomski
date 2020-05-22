protected void reset() {
        // sets up gold array
        randomGold = new Boolean[144];

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

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                // Reset the image icon with a blank image...
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }

        }
    }