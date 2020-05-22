long start = System.nanoTime();
    atual = Matrix.pot(inicial, n);
    power = new BigDecimal(Math.pow(2, m)).toBigInteger();
    M = atual.values[1].mod(power);
    long end = System.nanoTime();
    long runns = (end - start);
    double runs = ((double)runns)/1000000000.0;

    System.out.println(M);
    System.out.println(runs);