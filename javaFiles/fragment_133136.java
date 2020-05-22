for (int n = 1; n <= numberOfTransactions; n++) {
        for (int c = 0; c < numberOfcurrencies; c++) {
            double max = Double.NEGATIVE_INFINITY;
            double temp;
            for (int i = 0; i < numberOfcurrencies;i++) {
                temp = rates[0][i][c]*V[n-1][i];
                if (temp > max)
                    max = temp;
                temp = rates[1][i][c]*V[n-1][i];
                if (temp > max)
                    max = temp;
            }
            V[n][c] = max;
        }
    }