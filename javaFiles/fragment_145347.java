public void startNewMonth() {
    if(lastYearList != null)
    {
        for(PurchaseOrder po : lastYearList.getOrders()) {
            String foundID = po.getCustomerID();
            int valueOfOrder = po.getFullPriceValue();
            customersList.findCustomer(foundID).updateTotalOrdersValue(-valueOfOrder);
        }

        for (PurchaseOrder po : currentYearList.getOrders()) {
            lastYearList.addPurchaseOrder(po);
        }

        currentYearList.setListToEmpty();
    }
}