void createInvoice() {
    try {

        Invoice invoice = new Invoice();
        ReferenceType customerReferenceType = new ReferenceType();
        customerReferenceType.setName("abc");
        customerReferenceType.setValue("2");
        invoice.setCustomerRef(customerReferenceType);
        Line line = new Line();
        line.setAmount(new BigDecimal(15));
        line.setDetailType(LineDetailTypeEnum.SALES_ITEM_LINE_DETAIL);

        SalesItemLineDetail salesItemLineDetail = new SalesItemLineDetail();
        ReferenceType referenceType = customerReferenceType;
        referenceType.setName("Hours");
        referenceType.setValue("2");
        salesItemLineDetail.setItemRef(referenceType);
        line.setSalesItemLineDetail(salesItemLineDetail);

        List linesList = new ArrayList<Line>();
        linesList.add(line);
        invoice.setLine(linesList);

        this.service.add(invoice);
    } catch (FMSException e) {
        e.printStackTrace();
    }