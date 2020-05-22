import java.util.*;
import java.sql.*;

public class Test {
    public static void main(String[] args) {
        long retryDate = System.currentTimeMillis();

        int sec = 600;

        Timestamp original = new Timestamp(retryDate);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(original.getTime());
        cal.add(Calendar.SECOND, sec);
        Timestamp later = new Timestamp(cal.getTime().getTime());

        System.out.println(original);
        System.out.println(later);
    }
}