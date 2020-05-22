import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {

public static void main(String[] args) {

    List<String> firstList = new ArrayList<String>();
    firstList.add("");

    List<String> secondList = new ArrayList<String>();
    secondList.add("OP1004");

    List<String> thirdList = new ArrayList<String>();
    thirdList.add("OP1003");

    List<String> fourthList = new ArrayList<String>();
    fourthList.add("OP1006");
    fourthList.add("OP1044");
    fourthList.add("OP1046");

    List<String> fifthList = new ArrayList<String>();
    fifthList.add("OP1008");
    fifthList.add("OP1009");
    fifthList.add("OP1044");
    fifthList.add("OP1005");
    fifthList.add("OP1004");

    Map<String, List<String>> map = new HashMap<String, List<String>>();
    map.put("OP1004", firstList);
    map.put("OP1006", secondList);
    map.put("OP1005", thirdList);
    map.put("OP1009", fourthList);
    map.put("OP1016", fifthList);

    for (Map.Entry<String, List<String>> keyAndValue: map.entrySet()) {
        String key = keyAndValue.getKey();
        List<String> values = keyAndValue.getValue();

        if (values.isEmpty() || (values.size() < 2)){
            continue;
        }
        for (Map.Entry<String, List<String>> mapKeyAndValue: map.entrySet()) {

            String key1 = mapKeyAndValue.getKey();
            if (key.equals(key1)){
                continue;
            }
            List<String> values2 = mapKeyAndValue.getValue();

            if (values2.isEmpty() || (values2.size() < 2)){
                continue;
            }
            values2.removeAll(values);
        }
    }

    for (Map.Entry<String, List<String>> keyAndValue: map.entrySet()) {
        System.out.println("Key is " + keyAndValue.getKey() + " Values are " + keyAndValue.getValue());
    }
}
}