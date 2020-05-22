import java.math.BigDecimal;
import java.math.MathContext;

class ReadLongNumbersAsExcel {

 public static void main(String[] args) throws Exception{

  String v = "1.921099999999999E-2";
  double d = Double.parseDouble(v);
  System.out.println("raw: " + v);
  System.out.println("double: " + d);
  BigDecimal bd = new BigDecimal(d);
  v = bd.round(new MathContext(15)).toPlainString();
  System.out.println("like Excel: " + v);

 }
}