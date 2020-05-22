for (int i = 0; i < player.length; i++) {
            Player d = player[i];
            String chose;
            do {
                String chosenplayer = JOptionPane
                        .showInputDialog("Please choose a player:");
                System.out.println("you chose player: " + chosenplayer);
                chose = chosenplayer;

            } while (!d.getPlayerName().equals(chose));
            if (d.getPlayerTalon() > 0) {
                System.out.println("name=" + d.getPlayerName() + " talon="
                        + d.getPlayerTalon());
                d.setFreeTalons();
            }

        }
    }

Use this code.