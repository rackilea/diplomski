import java.util.*;

public class SO58133962 {
  public static void main(String[] args) {
    List<Map<String,Integer>> nameToCosts = new ArrayList<>();
    Map<String,Integer> one = new HashMap<>();
    one.put("322108888",2900);
    Map<String,Integer> two = new HashMap<>();
    two.put("321979826",3900);
    nameToCosts.add(one);
    nameToCosts.add(two);

    double sum = nameToCosts.stream().map(Map::values).flatMap(Collection::stream).mapToDouble(Integer::doubleValue).sum();
    System.out.println(sum);
  }
}