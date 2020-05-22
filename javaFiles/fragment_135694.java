public void getStatistics() {
    for (Customer customer: this.customers.getCustomer()) {
        BigDecimal customerTotalAmount = processCustomer(customer);
        this.totalAmount = this.totalAmount.add(customerTotalAmount);
    }
}

private void processCustomer(Customer customer){
    BigDecimal customerTotalAmount = new BigDecimal(0);
    for (Order order : customer.getOrders().getOrder()) {
        BigDecimal orderAmount = new BigDecimal(0);
        for (Position position : order.getPositions().getPosition()) {
            orderAmount = orderAmount.add( position.getPrice().multiply(new BigDecimal(position.getCount())) );
        }

        customerTotalAmount = customerTotalAmount.add(orderAmount);
        this.totalOrders++;
    }
    return customerTotalAmount;
}