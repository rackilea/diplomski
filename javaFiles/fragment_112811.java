import java.util.*;
public class ListManager {

public static void main(String[] args) {
    String[] items = {"snow", "rain", "ice", "sleet", "ice", "sunny"};
    List<String> criteriaList = new ArrayList<String>();
    String criteria;
    for (String newCriteria : items) {
        if (criteriaList.remove(newCriteria)) {
            System.out.println(newCriteria + " was in the list already");
        }
        criteriaList.add(0, newCriteria);
        System.out.println();
        System.out.print("List is: ");
        for (String x : criteriaList) {
            System.out.print(x +"  ");
        }
        System.out.println();
    }
}