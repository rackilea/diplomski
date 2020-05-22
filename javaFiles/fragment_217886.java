private String primos() {
    int i, j;
    boolean esPrimo;
    int rInicial = 2;//Rango inicial
    int rFinal = 200;//Rango final
    String primeSeries = "";
    for (i = rInicial; i <= rFinal; i++) {
        esPrimo = true;
        for (j = 2; j < i; j++) {
            if (i % j == 0) {
                esPrimo = false;
            }
        }
        if (esPrimo) {
           primeSeries += i + ", ";
        }
    }
    return primeSeries;
}