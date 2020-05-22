List<Invoice> invoices = new ArrayList<Invoice>();
InvoiceFillStrategy invoiceStrategy = new InvoiceFillStrategy();

System.out.println("Invoices for myCorp:");
fillListForName("myCorp", invoices, invoiceStrategy);
for (Invoice i : invoices) {
    System.out.println(i);
}

System.out.println("\nInvoices for otherCorp:");
invoices.clear();
fillListForName("otherCorp", invoices, invoiceStrategy);
for (Invoice i : invoices) {
    System.out.println(i);
}