import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MergeMap{

  public static final String DEPT = "Dept";
  public static final String EMPLOYEES = "Employees";
  public static final String ID = "ID";

  public static void main(String[] args) {
    List<Map<String, List<String>>> data = new ArrayList<>();

    Map<String, List<String>> map1 = new ConcurrentHashMap<>();
    Map<String, List<String>> map2 = new ConcurrentHashMap<>();
    Map<String, List<String>> map3 = new ConcurrentHashMap<>();

    map1.put(ID, Arrays.asList("100"));
    map1.put(DEPT, Arrays.asList("Accounting", "Finance"));
    map1.put(EMPLOYEES, Arrays.asList("100", "350"));

    map2.put(ID, Arrays.asList("200"));
    map2.put(DEPT, Arrays.asList("IT", "Technology"));
    map2.put(EMPLOYEES, Arrays.asList("300", "400"));

    map3.put(ID, Arrays.asList("100"));
    map3.put(DEPT, Arrays.asList("Health", "Medical"));
    map3.put(EMPLOYEES, Arrays.asList("450", "550"));

    data.add(map1);
    data.add(map2);
    data.add(map3);
    System.out.println(data);//previous list

    List<Map> expectedList = data
        .stream()
        .collect(
            Collectors.collectingAndThen(Collectors.toMap(e -> e.get(ID), Function.identity(),
                (left, right) -> {
                  List<String> dept = new ArrayList<>();
                  List<String> emp = new ArrayList<>();
                  dept.addAll(left.get(DEPT));
                  dept.addAll(right.get(DEPT));
                  emp.addAll(left.get(EMPLOYEES));
                  emp.addAll(right.get(EMPLOYEES));
                  left.put(DEPT, dept);
                  left.put(EMPLOYEES, emp);
                  return left;
                }
            ), m -> new ArrayList<>(m.values())));
    System.out.println(expectedList); // new list

  }

}