String[] spelersLijst;
aantalSpelers = Input.readInt();
   spelersLijst= new String[aantalSpelers ];
for (int g = 0; g < aantalSpelers; g++) {
    String naamSpeler = "Speler " + (g+1);
    spelersLijst [g] = naamSpeler;
}