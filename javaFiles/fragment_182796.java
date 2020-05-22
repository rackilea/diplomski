start();
do {
    spielerSymbol = (spielerSymbol == 1) ? 2 : 1;
    brett();
    zug();
} while (!siegBedingung());
System.out.println("Spieler " + spielerSymbol + " gewinnt.");