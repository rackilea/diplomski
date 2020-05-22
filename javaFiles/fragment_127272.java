public static  double calculateTotalCharges() {
    double standardCharge = calculateStayCharges();
    double miscCharges = calculateMiscCharges();
    double totalCharges=standardCharge+miscCharges;
    System.out.println("Your total charges are" + " " + totalCharges);
    return totalCharges;
}