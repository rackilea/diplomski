List<Invoice> invoiceList = new ArrayList<>();
//populate
Function<Invoice, BigDecimal> totalMapper = invoice -> invoice.getUnit_price().multiply(invoice.getQuantity());
BigDecimal result = invoiceList.stream()
        .map(totalMapper)
        .reduce(BigDecimal.ZERO, BigDecimal::add);