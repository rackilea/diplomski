final String[] header = new String[] { "First Name", "Last Name", "Birthday"};
final String[] fieldMapping = new String[] { "firstName", "lastName", "birthDate"};

// write the header
beanWriter.writeHeader(header);

// write the beans
for( final CustomerBean customer : customers ) {
   beanWriter.write(customer, fieldMapping , processors);
}