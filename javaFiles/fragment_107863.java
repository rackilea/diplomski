import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main 
{
  public static void recurse(int depth,
                      List<List<String>> current,
                      List<List<List<String>>> result,
                      List<List<String>> lists)
  {
    if (depth == lists.size()) {
      // Copy the list to the result
      result.add(new ArrayList<List<String>>(current));
      return;
    }
    // Iterate over the current-depth list
    List<String> list = lists.get(depth);
    for (String str: list) {
      List<String> elem = Arrays.asList(str);
      current.add(elem);   // Add the next element to the list
      recurse(depth + 1, current, result, lists);
      current.remove(depth);  // Clean up this element
    }
  }

  public static List<List<List<String>>> combinations(List<List<String>> allLists) 
  {
      // We'll fill it in
      List<List<List<String>>> result = new ArrayList<>();

      // Current, partial row in the final result
      List<List<String>> current = new ArrayList<>();

      recurse(0, current, result, allLists);

      return result;
  }

  public static void main(String[] args) {

    System.out.println("Hello World!");

    List<String> list1 = Arrays.asList("A", "B");
    List<String> list2 = Arrays.asList("B", "C", "E");
    List<String> list3 = Arrays.asList("D", "X");

    List<List<String>> allLists = Arrays.asList(list1, list2, list3);

    List<List<List<String>>> result = combinations(allLists);

    // Print
    for (List<List<String>> list: result) {
      System.out.print("{ ");
      for (List<String> elem: list)
        System.out.print("{" + elem.get(0) + "} ");
      System.out.println("}");
    }
  }
}