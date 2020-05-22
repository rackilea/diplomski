Client client = Mockito.mock(Client.class);
Class1 class1 = new Class1(client); //class that uses client and creates customer
ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);

class1.createCustomer(); //method that does create and save

verify(client).saveCustomer(customerCaptor.capture());
final Customer customer = Customer.getValue();

Assert.assertTrue(customer.isSetValid());
Assert.assertTrue(StringUtil.hasvalue(temp=customer.isGetValid.getValue()));
//do other asserts on customer