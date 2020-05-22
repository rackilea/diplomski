public class Invoice {
    private final String invoiceNumber;
    private final String customerName;
    private final Date invoiceDate;
    public Invoice(String invoiceNumber, String customerName, Date invoiceDate) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
    }
    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    public Date getInvoiceDate() {
        return this.invoiceDate;
    }
}