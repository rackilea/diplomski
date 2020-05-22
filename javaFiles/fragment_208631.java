public void actionPerformed(ActionEvent e) {
        while (guesses < images.length) {
            int count = 0;
            while (count < word.charAt(count)) { // probably here
                if (letterChoice[count].equals(word.charAt(count))) { // maybe here too
                    spaces[count] = new JLabel("" + letterChoice[count]
                            + "");
                    count++;
                } else
                    imageLabel.setIcon(images[imageNumber]);
                imageNumber++;
                imageLabel.repaint();
                guesses++;

            }