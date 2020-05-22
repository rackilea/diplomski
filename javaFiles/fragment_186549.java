public double calcAverageBill(java.util.List<Double> monthlyBill) {
  double sum = 0;
  if (!monthlyBill.isEmpty()) {
    for (double month : monthlyBill) {
      sum += month;
    }
  }
  return (sum / monthlyBill.size());
}