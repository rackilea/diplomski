import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);
  public static int total = 5;

  public static void main(String[] args) {
    addToTotal(5);
    addToTotal(199);
    System.out.println(addToTotal(1));
  }

  public static void addToTotal(int amount){
    total += amount;

    log.trace("Successfully added " + amount + " to total for result of " + total);
  }
}