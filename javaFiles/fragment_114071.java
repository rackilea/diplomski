ResultSet rs = pst.executeQuery();
Invoice invoice=new Invoice();
while(rs.next()){
    if (invoice.getDocNum().compareTo(rs.getString(1))!=0) {
         // This is a new Invoice, so process previous if not the first one
         // and create a new instance
         invoice=new Invoice();
         invoice.setDocNum(rs.getString(1));
         invoice.setCustomer(rs.getString(2));
         invoice.setInvoiceDetails(new ArrayList<InvoiceDetails>());
    }
    InvoiceDetails invoiceDetails = new InvoiceDetails();
    invoiceDetails.setTaxRate(rs.getString(3));
    // ... further member settings, and finally add to list:
    invoice.getInvoiceDetails.add(invoiceDetails);
}
// finally process the last Invoice if it is not empty