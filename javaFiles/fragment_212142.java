import java.util.Scanner; //Importar scanner

public class Eac4_001 {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Eac4_001 programa = new Eac4_001();
        programa.inicio();
    }

    public void inicio() {
        presentarPrograma();
        pedirNumeros();
    }

    public void presentarPrograma() {
        System.out.println("El programa pedirá dos números positivos.\n"
                + "El primero tiene que ser más pequeño que el segundo.\n"
                + "Luego enseñará los primeros y ultimos dos númberos del"
                + "rango conseguido.\n");
    }

    public void pedirNumeros() {
        int retry = 0;
        int input1, input2;
        boolean ok = false;

        do {
            System.out.print("Introduce un primer número: ");
            input1 = scanner.nextInt();
            System.out.print("Introduce un segundo número: ");
            input2 = scanner.nextInt();

            if (input1 > 0 && input2 > 0) {
                ok = true;
                //call your method from here.
                mostrarResultado(input1, input2);
            } else {
                System.out.print("Invalid Input. Try again.");
                if (retry < 3) {
                    retry++;
                } else {
                    break;
                }
            }

        } while (!ok);
    }

    public void mostrarResultado(int input1, int input2) {
        //Do whatever you want to do, here with these variables
    }
}