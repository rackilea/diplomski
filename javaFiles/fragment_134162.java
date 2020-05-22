import java.util.*;

public class Perm {
  static <T> List<List<T>> permutations(List<T> list) {
    if(list.isEmpty()) return new LinkedList<>();
    List<List<T>> result = new LinkedList<>();
    for(int i = 0; i < list.size(); i++) {
      T elem = list.get(i);
      List<T> copy = new LinkedList<>(list);
      copy.remove(i);
      List<List<T>> permRest = permutations(copy);
      if(permRest.isEmpty()) permRest.add(new LinkedList<>());
      for(List<T> perm: permRest) {
        List<T> permCopy = new LinkedList<>(perm);
        permCopy.add(0, elem);
        result.add(permCopy);
      }
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  static List<List> permutationsLists(List list) {
    if(list.size() == 0) {
      return new LinkedList<>();
    } if(!(list.get(0) instanceof List)) {
      return permutations(list);
    } else {
      List<List> permutationsFirst = permutationsLists((List)list.get(0));
      List<List> permutationsRest = (List<List>)permutationsLists(list.subList(1, list.size()));
      if(permutationsRest.size() == 0) permutationsRest.add(new LinkedList());
      List<List> result = new LinkedList<>();
      for(List pf: permutationsFirst) {
        for(List pr: permutationsRest) {
          List copy = new LinkedList(pr);
          copy.add(0, pf);
          result.add(copy);
        }
      }
      return result;
    }
  }

  public static void main(String[] args) {
    /*
    List<List<List<String>>> list = Arrays.asList(
      Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e", "f")),
      Arrays.asList(Arrays.asList("g", "h", "i", "j"), Arrays.asList("k", "l", "m", "n")),
      Arrays.asList(Arrays.asList("o", "p"), Arrays.asList("q", "r")),
      Arrays.asList(Arrays.asList("s", "t", "u"), Arrays.asList("v", "w", "x"))
    );
    */
    List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5));
    System.out.println(permutationsLists(list));
  }
}