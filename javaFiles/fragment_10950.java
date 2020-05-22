public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    double amount = Double.parseDouble(br.readLine());
    amount= Math.round(amount*100);     
    if (amount > 0 && amount < 1000000.00) {            
        // ############################# BILLS ############################
        double rest100 = amount / 10000;
        double rest50 = amount % 10000;
        double rest20 = rest50 % 5000;
        double rest10 = rest20 % 2000;
        double rest5 = rest10 % 1000;
        double rest2 = rest5 % 500;

        // ############################ COINS ############################            
        double rest01 = rest2 % 200;
        double rest050 = rest01 % 100;
        double rest025 = rest050 % 50;
        double rest010 = rest025 % 25;
        double rest005 = rest010 % 10;
        double rest001 = rest005 % 5;

        System.out.println("BILLS:\n"
            + (int) Math.floor(rest100)
            + " bill(s) of 100.00\n"
            + (int) (rest50 / 5000)
            + " bill(s) of 50.00\n"
            + (int) (rest20 / 2000)
            + " bill(s) of 20.00\n"
            + (int) (rest10 / 1000)
            + " bill(s) of 10.00\n"
            + (int) (rest5 / 500)
            + " bill(s) of 5.00\n"
            + (int) (rest2 / 200)
            + " bill(s) of 2.00\n"
            + "COINS:\n"
            + (int) (rest01 / 100)
            + " coin(s) of 1.00\n"
            + (int) (rest050 / 50)
            + " coin(s) of 0.50\n"
            + (int) (rest025 / 25)
            + " coin(s) of 0.25\n"
            + (int) (rest010 / 10)
            + " coin(s) of 0.10\n"
            + (int) (rest005 / 5)
            + " coin(s) of 0.05\n"
            + (int) (rest001 / 1)
            + " coin(s) of 0.01");
    }