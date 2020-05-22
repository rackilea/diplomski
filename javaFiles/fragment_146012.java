paths
    .stream()
    .map(Invoice::new)
    .map(e -> {
           e.setInvoiceInputStream(reader(e.getInvoicePath()));
           e.setInvoiceId(invoiceFinder.getInvoiceId(e.getInvoiceInputStream()));
           return e;

    })
    .collect(Collectors.toMap(
                  Invoice::getInvoiceId,
                  Function.identity())
            );