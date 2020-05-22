public final class CreatePurchase {
    private int invoiceNum;
    private double amount;
    private double totalamount;

    // I am hard-coding the sales tax as 5%, as you did in your question,
    // though this code can easily be modified if you also want to input the tax
    private final double tax = .05;

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static void main(String[] args) {
        CreatePurchase cp = new CreatePurchase();
        Scanner input = new Scanner(System.in);

        // these next two do-while loops will continue polling the user
        // until he enters a valid input
        do {
            System.out.println("Please enter the invoice number! (Must be between 1000 and 8000!)");
            invoiceNum = input.nextInt();
        } while (invoiceNum < 1000 || invoiceNum > 8000);

        cp.setInvoiceNum(invoiceNum);

        do {
            System.out.println("Please enter the amount of the sale! (Must be greater than 0!)");
            amount = input.nextDouble();
        } while (amount < 0);

        totalamount = amount*(1 + tax);
        cp.setAmount(amount);
        cp.setTotalAmount(totalAmount);

        // now use the CreatePurchase object to print out
        // details of the transaction
        System.out.println("Your invoice number is:" + cp.getInvoiceNum() + ".");
        System.out.println("Your sale amount is: " + cp.getAmount() + ".");
        System.out.println("Your sale amount after tax is: " + cp.getTotalAmount() + ".");
    }
}