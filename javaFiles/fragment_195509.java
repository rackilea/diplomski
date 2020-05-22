for(int i = 0; i < numPlayers; i++){
   input = JOptionPane.showInputDialog("Enter the player's name: ");
   if (input == null || input.equals(" "))
       throw new IllegalArgumentException("Must enter valid name!!!"); 
   nameOfPlayers[i] = new Player(input);
}