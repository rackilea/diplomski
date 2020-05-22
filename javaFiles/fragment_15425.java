public class CustomerToCustomerIdConverter implements Converter<String, Customer> {
    @Override
    public Result<Customer> convertToModel(String s, ValueContext valueContext) {
        return Result.error("not supported");
    }

    @Override
    public String convertToPresentation(Customer customer, ValueContext valueContext) {
        return Objects.toString(customer.getCustomerId(), "");
    }
}