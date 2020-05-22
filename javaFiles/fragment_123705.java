List<Customer> customers = new ArrayList<>();
Customer customerObj = null;
List<Tuple> customerTuples =queryFactory.select(customer.firstName,customer.status,customer.customerId).
                                from(customer).innerJoin(customerChat).on(customer.customerId.eq(customerChat.senderId)).
                                innerJoin(customerChatDetail).on(customerChat.chatDetailId.eq(customerChatDetail.chatDetailId)).
                                where(customerChatDetail.isRead.eq(true).and(customer.status.eq(true))).fetch();

    for (Tuple row : customerTuples) {
        customerObj = new Customer();
      customerObj.setFirstName(row.get(customer.firstName));
      customerObj.setStatus( row.get(customer.status));
      customerObj.setCustomerId(row.get(customer.customerId));
      customers.add(customerObj);
    }
return customers;