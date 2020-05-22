private static void verifierEntree() {
    int intcolonne2 = 0;
    int intligne2 = 0; 
    boolean entreeIncorrecte = true;
    while (entreeIncorrecte) {

        ligne = scan.nextLine();
        colonne = scan.nextLine();

        if (ligne.contentEquals("0")) {
        }
        if (ligne.equals("0") || ligne.equals("1") || ligne.equals("2") || ligne.equals("3")) {
            entreeIncorrecte = false;
        } else if (colonne.equals("0") || colonne.equals("1") || colonne.equals("2") || colonne.equals("3")) {
            entreeIncorrecte = false;
        } else {
            System.out.println("Mauvaise entree! Recommence! ");
            entreeIncorrecte = true;
        }
        if (!entreeIncorrecte) {
        // Comment colonne2 et ligne2 ne sont pas utilisés?
            //int colonne2 = Integer.parseInt(colonne);
            //int ligne2 = Integer.parseInt(ligne);
            try{
                intcolonne2 = Integer.parseInt(colonne);
                intligne2 = Integer.parseInt(ligne);
            } catch (NumberFormatException ignored){
                intcolonne2 = 0;
                intligne2 = 0; 
                entreeIncorrecte = true;
            }
        } //else {

        if(entreeIncorrecte){

        }
     }
 }