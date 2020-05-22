import java.util.*;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Perm {

  static <T> Stream<List<T>> permutations(List<T> list) {
    if(list.isEmpty()) return Stream.empty();
    return IntStream.range(0, list.size()).boxed().flatMap(i -> {
      T elem = list.get(i);
      List<T> copy = new LinkedList<>(list);
      copy.remove((int)i);
      Stream<List<T>> permRest = copy.isEmpty()?Stream.of(new LinkedList<>()):permutations(copy);
      return permRest.map(perm -> {
        List<T> permCopy = new LinkedList<>(perm);
        permCopy.add(0, elem);
        return permCopy;
      });
    });
  }

  @SuppressWarnings("unchecked")
  static <T> Stream<List<T>> permutationsLists(List<T> list) {
    if(list.size() == 0) {
      return Stream.empty();
    } if(!(list.get(0) instanceof List)) {
      return permutations(list);
    } else {
      List rawList = list;
      Stream<List> permutationsFirst = permutationsLists((List)list.get(0));

      return permutationsFirst.flatMap(pf -> {
        Stream<List> permutationsRest = list.size() < 2?Stream.of(new LinkedList()):permutationsLists(rawList.subList(1, list.size()));
        return permutationsRest.map(pr -> {
          List<T> copy = new LinkedList<>(pr);
          copy.add(0, (T)pf);
          return copy;
        });
      });
    }
  }

  public static void main(String[] args) throws Exception {
    List<List<List<String>>> list = Arrays.asList(
      Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e", "f")),
      Arrays.asList(Arrays.asList("g", "h", "i", "j"), Arrays.asList("k", "l", "m", "n")),
      Arrays.asList(Arrays.asList("o", "p"), Arrays.asList("q", "r")),
      Arrays.asList(Arrays.asList("s", "t", "u"), Arrays.asList("v", "w", "x"))
    );

    Stream<List<List<List<String>>>> result = permutationsLists(list);
    result.forEach(p -> System.out.println(p));
  }
}