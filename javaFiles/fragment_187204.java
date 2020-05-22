int colonne2 = 0;
int ligne2 = 0;
try{
   colonne2 = Integer.parseInt(colonne);
   ligne2 = Integer.parseInt(ligne);
} catch (NumberFormatException ignored){
    entreeIncorrecte = true;
}