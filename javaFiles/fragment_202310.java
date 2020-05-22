import java.util.Scanner;

public class Eac4P1_002 {
    Scanner scanner = new Scanner(System.in);

    //Método main
    public static void main (String[] args){
        Eac4P1_002 programa = new Eac4P1_002();
        programa.inicio();
    }
    //Método principal
    public void inicio() {
        presentacion();
        System.out.println("De que medida necesitas que sean las clases 1?");
        int medida = scanner.nextInt();
        int[] clase1 = introGetClase1(medida);
        int[] clase2 = introGetClase2(medida);
        resultado(clase1, clase2);
    }

    //Presentación
    public void presentacion(){
        System.out.println("Hola, bienvenid@ al ejercicio 2!\n"
                + "El programa os pedirá la edad de dos clases, "
                + "en enteros y comprueba si los valores de la segunda clase "
                + "son más grandes que los de la primera.");
    }
    //Inserción de datos
    public int[] introGetClase1(int medida){
        int clase1 [] = new int[medida];
        int contador = 0;
        int posicion = 1;

        System.out.println("Ahora deberás introducir el valor de cada "
                + "posición de la clase inicial.");
        while (contador < clase1.length){
            System.out.print("Escribe el valor de la posición "+posicion+": ");
            clase1[contador] = scanner.nextInt();
            contador++;
            posicion++;
            scanner.nextLine();
        }
        return clase1;
    }

    //Inserción de datos
    public int[] introGetClase2(int medida){
        int clase2 [] = new int[medida];
        int contador = 0;
        int posicion = 1;

        while (contador < clase2.length){
            System.out.print("Escribe el valor de la posición (clases 2)"+posicion+": ");
            clase2[contador] = scanner.nextInt();
            contador++;
            posicion++;
            scanner.nextLine();
        }
        return clase2;
    }

    public void resultado(int[]clase1, int[] clase2){
        System.out.println("Analisis de los datos coleccionados.\n");
        System.out.println("Colección 1:");
        for(int i=0; i < clase1.length; i++ ){
            System.out.print(clase1[i]);
        }
    }
}