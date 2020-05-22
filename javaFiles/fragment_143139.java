package strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testing {

  static List<String> list() {

    List<String> words = new ArrayList<String>();

    words.add("Cherry");
    words.add("Banana");
    words.add("Apple");
    words.add("Banana");
    words.add("Berry");
    words.add("Banana");
    words.add("Berry");
    words.add("Banana");

    return words;
  }

  static Map<String, Integer> ArrayFrequencies(List<String> words) {

    Map<String, Integer> frequencies = new HashMap<String, Integer>();

    for (String element : words) {

      if (!frequencies.containsKey(element)) {
            System.out.println("Seems like => " + element + "  is not in the list yet. Adding it" );
        frequencies.put(element, 1);
      } else {

           System.out.println("Seems like => " + element + " is in the list already. Incrementing its count from  : " + 
                              frequencies.get(element) + "  => to   : " + (frequencies.get(element) + 1) );
        frequencies.put(element, frequencies.get(element) + 1);
      }
    }

    return frequencies;
  }

  public static void main(String[] args) {

    System.out.println(ArrayFrequencies(list()));
  }
}