public static void primeGenerator() {
        BigInteger[] primeList = new BigInteger[10];
        BigInteger startLine = new BigInteger("1");
        int startPower = 1;
        BigInteger endLine = new BigInteger("10");
        int endPower = 2;
        int j = 0;
        for (BigInteger i = startLine.pow(startPower); i.compareTo(endLine
                .pow(endPower)) <= 0; i = i.add(BigInteger.ONE)) {
            if (checkPrimeFermat(i) == true && j < 10) {
                primeList[j] = i;
                j++;
            }
        }

        System.out.print(Arrays.toString(primeList));

    }