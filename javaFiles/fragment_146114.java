ClassMapBuilder<CustomerAddresses, Customer> builder;

    builder= mapperFactory.classMap(CustomerAddresses.class, Customer.class).constructorA();

    builder.field("previousAddresses.previousAddress{streetNo}","customerAddresses{streetNumber}");
    builder.field("previousAddresses.previousAddress{streetName}","customerAddresses{streetName}");

    builder.register();

    BoundMapperFacade<CustomerAddresses, Customer> boundMapper;

    boundMapper = mapperFactory.getMapperFacade(CustomerAddresses.class, Customer.class);

    destination = boundMapper.map(source, destination);