class Main {

    public static void main(String[] args) {

        double netIncome = 55000;

        int levels = 3;
        double[] threshold = {0, 15000, 29000, 50000};
        double[] rate = {0, 15,20,25};

        double taxOwd = 0;

        double taxableIncome = 0;
        double netIncomeLeft = netIncome;

        for (int i = levels; i > 0; i--) {
            taxableIncome = netIncomeLeft - threshold[i];
            taxOwd += taxableIncome * (rate[i]/100);
            netIncomeLeft = threshold[i];
        }
        System.out.println("taxOwd " + taxOwd);
    }
}