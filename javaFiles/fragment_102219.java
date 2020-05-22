import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortList {

    public static void main(String[] args) {
        List<String> yearList = new ArrayList<>(25);
        yearList.add("042011");
        yearList.add("052011");
        yearList.add("062011");
        yearList.add("072011");
        yearList.add("082011");
        yearList.add("092011");
        yearList.add("102010");
        yearList.add("112010");
        yearList.add("122010");
        yearList.add("012011");
        yearList.add("022011");
        yearList.add("032011");

        Collections.sort(yearList, new Comparator<String>() {
            private DateFormat format = new SimpleDateFormat("MMyyyy");

            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                try {
                    Date d1 = format.parse(o1);
                    try {
                        Date d2 = format.parse(o2);
                        result = d1.compareTo(d2);
                    } catch (ParseException ex) {
                        result = -1;
                    }
                } catch (ParseException ex) {
                    result = 1;
                }
                return result;
            }
        });
        System.out.println(yearList);
    }

}