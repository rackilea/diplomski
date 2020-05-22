System.out.println("Loading players:");
for(int i = 0; i < jugadores.length; i++) { // Better readability.
        s=JOptionPane.showInputDialog("Name of player "+i+": ");
        Jugador x = new Jugador(s);
        jugadores[i] = x; // Added
        System.out.println("Player "+i+": "+x.getName());
}