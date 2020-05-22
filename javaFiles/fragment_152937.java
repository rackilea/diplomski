if (P1Rock.isSelected()) {
   if (P2Scissors.isSelected()) {
     statusLabel.setText("Player 1 wins: Rock crushes Scissors");
   } else if (P2Paper.isSelected()) {
     statusLabel.setText("Player 2 wins: Scissors cut Paper");
   } else if (P2Rock.isSelected()) {
     statusLabel.setText("It's a tie!");
   } else if (P2Lizard.isSelected()) {
     statusLabel.setText("Player 1 wins: Rock crushes Lizard");
   } else if (P2Spock.isSelected()) {
     statusLabel.setText("Player 2 wins: Spock vaporizes Rock");
   }
} else if (P1Scissors.isSelected()) {
   if (P2Scissors.isSelected()) {
     ... // and so on