public static double netIncome(double income) {

  double tax = 0;

  // high income bracket
  if (income > 45000) {
    double part = income - 45000;
    tax += part * 0.4;
    income = 45000;
  }

  // medium income bracket
  if (income >  7500) {
    double part = income - 7500;
    tax += part * 0.2;
  }

  // tax for low income is zero, we don't need to compute anything.

  return tax;
}