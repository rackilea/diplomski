import java.util.Date;




public class Test {

/**
 * @param args
 */
public static void main(String[] args) {
     Date start = new Date(2013, 07, 14, 12, 45, 0);
     Date end = new Date(2013, 07, 14, 21, 0, 0);
     System.out.println((end.getTime()-start.getTime())/1000);
}