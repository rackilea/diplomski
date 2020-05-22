public double getNumSubscriptionsInCountryForPeriod(String country, int sYear, int eYear) {
    double sum = 0;

    for (int i = 1; i < array.length; i++) {

        if (country.equalsIgnoreCase((String) array[i][0])) {
            int start = 1 + sYear - year;
            int end = start + (eYear - sYear);

            if (start >= 0 && end < array[i].length) {

                for (int k = start; k <= end; k++) {
                    // System.out.println(">> " + country + " adding " + array[i][k]);
                    sum += (Double) array[i][k];
                }
            }
        }
    }

    return sum;
}