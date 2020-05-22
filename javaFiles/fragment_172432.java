public static int eseguiSomma(int numero){
    //Caso base
    if (numero < 10) {
        return numero;
    }

    //Chiamate ricorsive
    return numero % 10 + eseguiSomma(numero / 10);
}

// now simply call without somma
int risultato = eseguiSomma(numero);