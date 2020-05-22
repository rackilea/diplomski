import java.util.*;

public class prova1 {
    public int min;

    public int[] tabele() {
        Random r = new Random();
        int d;
        int e[]= new int[100];
        for(int i=0; i<e.length;i++){
            d=r.nextInt(99) + 1;
            e[i]=d;
            System.out.println(e[i]);
        }

        return e;
    }

    public void emin(int[] e) {
        Random r = new Random();
        int d;
        for(int i=0; i<e.length;i++) {
            if(e[i]<min) {
                min=e[i];
            }
        }

        System.out.println("Vlera me e vogel eshte: " +min);
    }

    public static void main(String []args){
        prova1 prova = new prova1();
        int[] arr = prova.tabele();
        prova.emin(arr);
    }
}