public class EnkelRekursjon1 {

    private static String funksjonNavn= "";
    private static int resultat=0;
    public static void main(String[] args) {

        int tall = 3; 
       System.out.print(tall+"! = "+faktor(3)); // resultat printes etter rekursjon 
    }

    private static int faktor(int tall){
    funksjonNavn="Faktor("+tall+")"; 
    System.out.println(tall);
    //finn hvilken funksjon vi er. 
    System.out.println("Funksjonen kaller "+ funksjonNavn);
    if (tall != 1){
        resultat= faktor(tall - 1)*tall; 
        System.out.println("Reusltatet er "+ resultat);
        return resultat; 
    }
    System.out.println("-------------------------------");
    //finn resultat for hver "rekursjon"
    System.out.println("Reusltatet er "+ (resultat+1));
    //blir 1* 0 her tror jeg, så funksjonen returnerer 1 istedenfor 0   
        return 1; 
    }

}