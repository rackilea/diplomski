public class Program {

/**
 * Prints the list of numbers from desde to hasta such that the righmost
 * digit of the sum of previous digits equals current digit, and that
 * happens for all digits
 * 
 * Prints a 2nd line with as many underscores as characters contains the 1st
 * line
 * 
 * If desde < 10 o the parameters make no sense, prints Err __
 * 
 * 
 * @param desde
 *            int from (included)
 * @param hasta
 *            int to (included)
 * @return void
 */
public static void sumDigitsConsecutius(int desde, int hasta) {

    int suma = 0;
    int numeroSuma = 0;

    for (int i = desde; i <= hasta; i++) {

        int longitud = lenght(i);
        int contador = 0;

        suma = 0;
        for (int posicion = longitud; posicion > 0; posicion--) {


            numeroSuma = posicioNumber(i, posicion);
            if (posicion !=longitud && suma != numeroSuma) {
                break;
            } else {
                contador++;
            }
            suma = suma + numeroSuma;

            //If the sum greater than 9 then position discarded 
            if(suma>=10){
                suma=suma%10;
            }
        }

        if (contador == longitud ) {
            System.out.println(i);
        }

    }

}

/**
 * With this method i can calculate the length of a number
 */

public static int lenght(int numero) {

    int contador = 0;

    while (numero > 0) {
        contador++;
        numero = numero / 10;
    }
    return contador;

}

public static int posicioNumber(int numero, int posicio) {

    // Digit of n in position p
    int x;
    // Remove right digits from position p.
    x = numero / (int) Math.pow(10, posicio - 1);
    // Get the last digit.
    x = x % 10;
    return x;

}

public static void main(String[] args) {
    sumDigitsConsecutius(1, 1000);
}


}