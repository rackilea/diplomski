public class Order {

    @JsonView(OrderViews.OnlySomeFields.class)
    private String foo;

    @JsonView(OrderViews.AllFields.class)
    private String bar;

    // getters/setters/etc
}