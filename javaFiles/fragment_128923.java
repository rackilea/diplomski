public synchronized Registrant save(Registrant registrant) {
    long counter = getInvoiceNumber();
    registrant.setInvoiceNumber(counter);

    return registrantRepository.save(registrant);
}

private long getInvoiceNumber() {
    //mist: get the invoice number from the other table
    long count = registrantInvoiceNumberGeneratorRepository.count();
    if(count > 1) {
        throw new RuntimeException(": InvoiceNumberGenerator table has more than one row. Fix that");
    }

    Registrant.InvoiceNumberGenerator generator;
    if(count == 0) {
        generator = new Registrant.InvoiceNumberGenerator();
        generator.setCounter(1000001);
        generator = registrantInvoiceNumberGeneratorRepository.save(generator);
    } else {
        generator = registrantInvoiceNumberGeneratorRepository.findFirstByOrderByIdAsc();
    }


    long counter = generator.getCounter();
    generator.setCounter(counter+1);
    registrantInvoiceNumberGeneratorRepository.save(generator);
    return counter;
}