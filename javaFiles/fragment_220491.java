void execute() {
    double initial_money = input
            .getDoubleValueFromUser("Your initial amount");
    double prime_rate = input
            .getDoubleValueFromUser("Enter the Prime Rate");
    double InterestRate = input
            .getDoubleValueFromUser("Enter the Interest Rate as a value above prime");
    double time = input
            .getDoubleValueFromUser("Enter the length of the investment in years to a decimal");
    double InterestRate2 = input
            .getDoubleValueFromUser("Enter the second Interest Rate as a value above prime");

    Calculations(initial_money, prime_rate, InterestRate, time);
    Calculations2(initial_money, prime_rate, InterestRate2, time);

}