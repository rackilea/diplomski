public static void main(String[] args) {

        String[]Names = {"Person","Human","Being"};
        int[]Money = {56,23,76};

        int minValue = Money[0];
        int minIndex = 0;
        for (int i = 0; i < Money.length; i++) {

            if (Money[i] < minValue) {
                minValue = Money[i];
                minIndex = i;
            }
        }
        System.out.println ("The person with least amount of money is: " + Money[minIndex] + "  "+ Names[minIndex]);
    }