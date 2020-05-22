public class CustomerDataMapper implements FieldSetMapper<Customer> {
   private static Log log = LogFactory.getLog(CustomerDataMapper.class);

   @Override
   public RawData mapFieldSet(FieldSet fieldSet) throws BindException {
      Customer customer = new Customer();

      try {
          customer.setCust_Num(fieldSet.readInt("id"));
          customer.setName_Surname(fieldSet.readString("name"));
      }catch (Exception e){
          log.error("Mapping error, " + e);
      }
      return customer;
   }
}