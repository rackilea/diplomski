private static void verifierEntree() {
    int intcolone;
    int intligne;
    boolean entreeIncorrecte = true;
    while (entreeIncorrecte) {

        ligne = scan.nextLine();
        colonne = scan.nextLine();
        switch(ligne){
        case "0": 
        case "1":
        case "2":
        case "3":
            entreeIncorrecte = false;
            intligne = ligne.charAt(0)-'0';
            break;
        default: entreeIncorrecte = true;
        } 

        switch(colonne){
         case "0":
         case "1":
         case "2":
         case "3":
            intcolone = colonne.charAt(0)-'0';
            break;
         default: entreeIncorrecte = true;

         } 
         if(entreeIncorrecte) {
            System.out.println("Mauvaise entree! Recommence!");
         }
     }
 }