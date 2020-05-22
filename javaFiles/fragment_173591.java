b.forField(id)
            .withConverter(Integer::valueOf, String::valueOf, "Invalid")
            .withNullRepresentation(0)
            .withValidator(new IntegerRangeValidator("Value must be greater than 0 ", 1, null))
            .bind(Customer::getId, Customer::setId);
    b.forField(name)
            .bind(Customer::getName, Customer::setName);
    b.readBean(customer);