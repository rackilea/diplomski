public class TaxReturnTester
{
    public static void main(String[] args)
    {
        TaxReturn tax = new TaxReturn(80500.5, 20000.00, 3, 5000.00);
        tax.calculateTax();
        System.out.println(tax.printTaxReturn());
    }
}