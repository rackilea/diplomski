public class BookOrder {
    public String ordernumber;
    public String customerName;
    public Date orderDate;
    public double discount;
    public float totalamount;
    public BookOrder(String on, String cn, Date od, double disc) {
        ordernumber = on;
        customerName = cn;
        orderDate = od;
        discount = disc;
        totalamount = 0;
    }
    public void addAmount(float amount) {
        totalamount += amount * discount;
    }
 }