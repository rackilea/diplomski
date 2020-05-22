// Prompt user for two invoices
List<Invoice> invoices = new ArrayList<>();
for (int i = 1; i < 3; i++) {
    String invoiceNumber = JOptionPane.showInputDialog("Invoice Number:");
    String customerName = JOptionPane.showInputDialog("Customer Name:");
    invoices.add(new Invoice(invoiceNumber, customerName, new Date()));
}

// Insert invoices
try (Connection dbConnection = DriverManager.getConnection(DR_URL, DB_USER, DB_PASSWORD)) {
    String sql = "INSERT INTO INVOICEMAIN VALUES (?,?,?)";
    try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
        for (Invoice invoice : invoices) {
            stmt.setString(1, invoice.getInvoiceNumber());
            stmt.setString(2, invoice.getCustomerName());
            stmt.setDate  (3, new java.sql.Date(invoice.getInvoiceDate().getTime()));
            stmt.addBatch();
        }
        stmt.executeBatch();
    }
}