@FixedLengthRecord(length = 4, paddingChar = ' ', header = OrderHeader.class, footer = OrderFooter.class)
    public class Order {

     private OrderHeader header;
    private  OrderFooter footer;
}