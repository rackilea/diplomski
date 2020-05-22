import static proyectoTeclado.Teclado.*;

public class Ejercicio10 {

    public static void main(String[] args) {

        int num=1,max=0;
        int valor[]=new int[10];
        boolean stop=false;

        while(!stop) {
            System.out.println("Introduce numero: ");
            num=leerInt();
            if(num>=0&&num<=9) {
                valor[num]++;
                if(valor[num]>max) {
                    max=valor[num];
                }
            }else if(num>9) {
                System.out.println("Introduce solo entre 0 o 9, si quieres parar pon un numero negativo.");
            }else {
                stop=true;
            }
        }

        histograma(valor,max);

    }


    public static void histograma(int[] v, int max) { // Hace el histograma

        for(int i=max; i>0; i--) {
            for(int j=0; j<v.length; j++) {
                if(v[j]>=i) {
                    System.out.print("* ");

                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        for(int i=0; i<10; i++) {
            System.out.printf("%d ",i);
        }

    }

}