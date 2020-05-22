import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class UserManual {

  public static void main(String[] args) {
    Map<String, Integer> months = new HashMap<String, Integer>();
    months.put("January", 1);
    months.put("February", 2);
    months.put("March", 3);
    months.put("April", 4);
    months.put("May", 5);
    months.put("June", 6);
    months.put("July", 7);
    months.put("August", 8);
    months.put("September", 9);
    months.put("October", 10);
    months.put("November", 11);
    months.put("December", 12);
    Scanner scan = new Scanner(System.in);
    String manual = scan.next();
    String strMonth = "";
    if (months.containsKey(manual)) {
      strMonth = manual;
    } else if (months.containsValue(Integer.valueOf(manual))) {
      for (Entry<String, Integer> entry : months.entrySet()) {
        if (entry.getValue().equals(Integer.valueOf(manual))) {
          strMonth = entry.getKey();
        }
      }
    }
    if (!strMonth.equals("")) {
      System.out.println("Valid Month --> " + strMonth);
    } else {
      System.out.println("Input is invalid!");
    }
    scan.close();
  }
}