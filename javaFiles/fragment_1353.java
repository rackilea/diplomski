import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorted {

public static void main(String[] args) {
    Map<String, Records> out = new HashMap<String, Records>();

    List<String> al = new ArrayList<String>();
    al.add("51b6f5fde4b0dd92df2c3270");
    al.add("51b866e9e4b021170dd1ae1c");
    Records record = new Records("02-Oct-2015", "S", al);
    out.put("student1", record);

    al = new ArrayList<String>();
    al.add("51b6f5fde4b0dd92df2c3271");
    al.add("51b866e9e4b021170dd1ae12");
    record = new Records("03-Oct-2015", "S", al);
    out.put("Student2", record);

    al = new ArrayList<String>();
    al.add("51b6f5fde4b0dd92df2c3271");
    record = new Records("03-Oct-2016", "S", al);
    out.put("Student3", record);
    process(out);

}

public static void process(Map<String, Records> records) {
    HashMap<String, HashMap<String, Integer>> m = new HashMap<String, HashMap<String, Integer>>();
    HashMap<String, Integer> month = null;
    for (String recordKey : records.keySet()) {
        Records r = records.get(recordKey);
        String s[] = r.getsDate().split("-");
        if (!m.containsKey(s[2])) {
            month = new HashMap<String, Integer>();
            m.put(s[2], month);
        }
        HashMap<String, Integer> m1 = m.get(s[2]);
        if (!m1.containsKey(s[1])) {
            m1.put(s[1], records.get(recordKey).getSMSSent().size());
        } else {
            int flag = m1.get(s[1]);
            m1.put(s[1], flag + records.get(recordKey).getSMSSent().size());
        }
    }
    display(m);
}

public static void display(HashMap<String, HashMap<String, Integer>> d) {
    int i = 0;
    for (String s : d.keySet()) {
        Map<String, Integer> m = d.get(s);
        for (String s1 : m.keySet()) {
            System.out.print(i++);
            System.out.print("\t");
            System.out.print(s);
            System.out.print("\t");
            System.out.print(s1 + "\t" + m.get(s1));

            System.out.println("");
        }
    }
}

}

class Records {
private String sDate;
private String status;
private List<String> SMSSent;

public Records(String sDate, String status, List<String> sMSSent) {
    super();
    this.sDate = sDate;
    this.status = status;
    SMSSent = sMSSent;
}

public String getsDate() {
    return sDate;
}

public void setsDate(String sDate) {
    this.sDate = sDate;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public List<String> getSMSSent() {
    return SMSSent;
}

public void setSMSSent(List<String> sMSSent) {
    SMSSent = sMSSent;
}

}