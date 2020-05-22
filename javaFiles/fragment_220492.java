double Calculations(double initial_money, double prime_rate,
        double InterestRate, double time) {
    double totalrate = prime_rate + InterestRate;
    double totalrate2 = totalrate / 100.0;
    double totalrate3 = totalrate2 + 1.0;
    double totalrate4 = Math.pow(time, totalrate3);

    return totalrate4;

}

double Calculations2(double initial_money, double prime_rate,
        double InterestRate2, double time) {
    double totalrate1a = prime_rate + InterestRate2;
    double totalrate2a = totalrate1a / 100.0;
    double totalrate3a = totalrate2a + 1.0;
    double totalrate4a = Math.pow(time, totalrate3a);
    // double final_amounta = initial_money * totalrate4;

    return totalrate4a;

}