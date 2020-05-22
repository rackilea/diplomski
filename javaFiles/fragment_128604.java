import java.text.DecimalFormat;

class TestClass {
public static void main(String[] args) {

double gross = 4322.12d;
double tax = 397.04d;

double net = gross - tax;
double fee = gross * 0.30d;
double vat = fee * 0.20d;
double takeHome = net - (fee + vat);
DecimalFormat df = new DecimalFormat("#.##");
System.out.println("Gross Refund :" + df.format(gross));
System.out.println("Tax Deducted :" + df.format(tax));
System.out.println("Net Refund :" + df.format(net));
System.out.println("Our Fee :" + df.format(fee + vat));
System.out.println("Funds remaining after deductions :" +df.format(takeHome));
}
}