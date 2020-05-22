import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public class TableSorting
{
  public static void main(String[] args)
  {
    // Columns of table
    String[] columns = {"Name of Coupon Provider", "Name of product", "Price of product",
        "Discount rate of the coupon (%)", "Final price", "Expiration Period", "Status of a coupon"};

    //Data of table
    List<Coupon> couponArray = Arrays.asList(
        new Coupon("aaa", "bbb", 100.2, 1, 1, "a"),
        new Coupon("aaa", "bbb", 60.2, 1, 1, "a"),
        new Coupon("aaa", "bbb", 160.4, 1, 1, "a"),
        new Coupon("aaa", "bbb", 220.2, 1, 1, "a"),
        new Coupon("aaa", "bbb", 70.2, 1, 1, "a"),
        new Coupon("aaa", "bbb", 150.2, 1, 1, "a"),
        new Coupon("aaa", "bbb", 160.3, 1, 1, "a"),
        new Coupon("aaa", "bbb", 210.3, 1, 1, "a"));

    int lengthArray = couponArray.size();
    Object data[][] = new Object[lengthArray][7];
    for (int i = 0; i < lengthArray; i++){
      Coupon sTmp = couponArray.get(i);
      data[i][0] = sTmp.getNameOfCouponProvider();
      data[i][1] = sTmp.getNameOfProduct();
      data[i][2] = sTmp.getPriceOfProduct();//Double.toString(sTmp.getPriceOfProduct());
      data[i][3] = Integer.toString(sTmp.getDiscountRateOfCoupon());

      //Get final price
      double finalPrice = sTmp.getPriceOfProduct() -
          sTmp.getPriceOfProduct()*((double)sTmp.getDiscountRateOfCoupon()/100);
      data[i][4] = new Formatter().format("%.2f", finalPrice).toString();
      data[i][5] = Integer.toString(sTmp.getExpirationPeriod());
      data[i][6] = sTmp.getStatusOfCoupon();
    }

    DefaultTableModel tableModel = new DefaultTableModel(data, columns) {

      @Override
      public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
      }

      //This makes values in "Price" column treated as numerical values
      // instead of String values.
      @Override
      public Class<?> getColumnClass(int columnIndex)
      {
        if (columnIndex == 2)
        {
          return Double.class;
        }
        return super.getColumnClass(columnIndex);
      }
    };
    JTable table = new JTable();
    table.setModel(tableModel);

    //Sort table
    table.setAutoCreateRowSorter(true);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }
}

class Coupon
{
  private String nameOfCouponProvider;
  private String nameOfProduct;
  private double priceOfProduct;
  private int discountRateOfCoupon;
  private int expirationPeriod;
  private String statusOfCoupon;

  Coupon(String nameOfCouponProvider, String nameOfProduct,
         double priceOfProduct, int discountRateOfCoupon,
         int expirationPeriod, String statusOfCoupon)
  {
    this.nameOfCouponProvider = nameOfCouponProvider;
    this.nameOfProduct = nameOfProduct;
    this.priceOfProduct = priceOfProduct;
    this.discountRateOfCoupon = discountRateOfCoupon;
    this.expirationPeriod = expirationPeriod;
    this.statusOfCoupon = statusOfCoupon;
  }

  String getNameOfCouponProvider() { return nameOfCouponProvider; }
  String getNameOfProduct() { return nameOfProduct; }
  double getPriceOfProduct() { return priceOfProduct; }
  int getDiscountRateOfCoupon() { return discountRateOfCoupon; }
  int getExpirationPeriod() { return expirationPeriod; }
  String getStatusOfCoupon() { return statusOfCoupon; }
}