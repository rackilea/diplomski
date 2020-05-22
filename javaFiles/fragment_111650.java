@Given("^I have the following order$")
public void i_have_another_order(List<OrderItem> list) throws Throwable {
    for (OrderItem orderItem : list) {
        // do something with my OrderItem..
        System.out.println(orderItem.getVeg());
    }
}