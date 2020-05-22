List<BrokerInvoiceLineItem> brokerInvoiceLineItemList = new ArrayList<BrokerInvoiceLineItem>();
for (int i = 0; i < workbookXls.getNumberOfSheets(); i++) {
    brokerInvoice = readinginvoiceimpl.findHeaderRowNumber(workbookXls, 0, brokerInvoiceLineItemList, brokerInvoice , brokerIdLong , finalfilteredfilename,dateType );
    for (BrokerInvoiceLineItem item : brokerInvoice.getLineItems()) {
        if (item.getreaddeate() == null) {
            throw new BOARuntimeException("readdeate is not there" );
        }
    }
    totalBrokerInvoiceObjects.addAll(brokerInvoice.getLineItems());
}