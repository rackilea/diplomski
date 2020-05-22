long noOfDecimals = 987654321L * 7L;

    BigDecimal bd = new BigDecimal("54141948"); // last 8 digits of base
    bd = bd.pow(379721);
    bd = bd.remainder(moduloBase);
    bd = bd.pow(2601);
    bd = bd.remainder(moduloBase);

    double result = bd.doubleValue() / 10_000_000.0; // print with 7 decimals
    System.out.println("Result is " + result + "e" + (-(noOfDecimals - 7)));