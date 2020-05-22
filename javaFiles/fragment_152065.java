public class Order
    @Valid
    protected Header header;
    @Valid
    protected List<Detail> details;
}