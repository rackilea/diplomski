for (i = 0; i < names.length; i++) {
        StringBuffer sbr = new StringBuffer();

        while (inFile.hasNext("[a-zA-Z]+")) {
            sbr.append(inFile.next() + " ");
        }
        names[i] = sbr.toString().trim();

        if (inFile.hasNextDouble()) {
            money[1][i] = inFile.nextDouble();
            money[2][i] = inFile.nextDouble();
        }
    }