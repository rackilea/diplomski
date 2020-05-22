import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class CollectionSorter {

    public static void main(String args[]) {
        ClassTest obj1 = new ClassTest();
        obj1.setCode("01");
        obj1.setDate("2001-02-01");
        ClassTest obj2 = new ClassTest();
        obj2.setCode("01");
        obj2.setDate("2001-01-01");
        ClassTest obj3 = new ClassTest();
        obj3.setCode("02");
        obj3.setDate("2001-01-01");

        List list = new ArrayList();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        System.out.println("Before sorting - " + list);
        Collections.sort(list, new ClassTestComparator());
        System.out.println("After sorting - " + list);
    }

}

class ClassTest{    
    private String code; // "01", "02" or "03".
    private String date; // 01/01/2001.

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString()
    {
        return "[code: " + code + ", date: " + date + "]";
    }
}

class ClassTestComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        ClassTest obj1 = (ClassTest) o1;
        ClassTest obj2 = (ClassTest) o2;
        int code1 = Integer.parseInt(obj1.getCode());
        int code2 = Integer.parseInt(obj2.getCode());
        int result = 0;
        if(code1 > code2) {
            result = 1;
        }
        if(code1 < code2) {
            result = -1;
        }
        if (result != 0) {
            return result;
        }

        // Sort by Date ("by the closest date of the current date")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse(obj1.getDate());
            date2 = sdf.parse(obj2.getDate());
        } catch(ParseException e) {
            e.printStackTrace();
        }
        if(date1.compareTo(date2)>0){
            result = 1;
        }else if(date1.compareTo(date2)<0){
            result = -1;
        }else if(date1.compareTo(date2)==0){
            result = 0;
        }
        return result;
    }

}