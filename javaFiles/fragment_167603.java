import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestArabic {
public static void main(String[] args) {

    Map<Integer, NationalityDto> m = new HashMap<Integer, NationalityDto>();

    NationalityDto n2 = new NationalityDto();
    n2.setNatid(102);
    n2.setDesc("الهند");
    m.put(102, n2);
    NationalityDto n3 = new NationalityDto();
    n3.setNatid(103);
    n3.setDesc("سعودي");
    m.put(103, n3);
    NationalityDto n1 = new NationalityDto();
    n1.setNatid(101);
    n1.setDesc("مصر");
    m.put(101, n1);
    NationalityDto n4 = new NationalityDto();
    n4.setNatid(104);
    n4.setDesc("الكويت");
    m.put(104, n4);
    NationalityDto n5 = new NationalityDto();
    n5.setNatid(105);
    n5.setDesc("لبنان");
    m.put(105, n5);
    System.out.println(m);

    Map sortedMap = sortByValue(m);


    System.out.println(sortedMap);

}

private static Map sortByValue(Map m) {
    Map<Integer, NationalityDto> sortedMap = new TreeMap(new ValueComparator(m));
    sortedMap.putAll(m);
    return sortedMap;
}
}

class ValueComparator implements Comparator<Integer> {
Map<Integer, NationalityDto> map;

public ValueComparator(Map map) {
    this.map = map;
}

public int compare(Integer s1, Integer s2) {
    // TODO Auto-generated method stub
    return ((NationalityDto) map.get(s1)).getDesc().compareTo(((NationalityDto) map.get(s2)).getDesc());
}
}