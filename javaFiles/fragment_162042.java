import java.util.HashMap;
import java.util.Map;

public class Mix {

  public static void main(String[] args) {
    System.out.println( mix("A aaaa bb c", "& aaa bbb c d") );
  }

  public static String mix(String s1, String s2) {

    Map<Character, Integer> firstStringCharsOccurences = new HashMap<>();
    Map<Character, Integer> secondStringCharsOccurences = new HashMap<>();
    Map<Character, Integer> total = new HashMap<>();


    for(int i=0; i<s1.length(); i++) {

        if (Character.isLowerCase(s1.charAt(i))) {
            /*
             * it will put a pair into the map with the char at index i as key and the value either the old value+1
             * if it already exist, or if this is the first occurrence of this character it will put 0+1 
             */
            firstStringCharsOccurences.put(s1.charAt(i),
                    firstStringCharsOccurences.getOrDefault(s1.charAt(i), 0) + 1);
        }
    }
    for(int i=0; i<s2.length(); i++) {
        if (Character.isLowerCase(s2.charAt(i))) {
            secondStringCharsOccurences.put(s2.charAt(i),
                    secondStringCharsOccurences.getOrDefault(s2.charAt(i), 0) + 1);
        }
    }

    for( Character c: secondStringCharsOccurences.keySet() ) {

    total.put(c, 
            Math.max(firstStringCharsOccurences.getOrDefault(c, 0),secondStringCharsOccurences.get(c)));
}

for( Character c: firstStringCharsOccurences.keySet() ) {

    total.put(c, 
            Math.max(secondStringCharsOccurences.getOrDefault(c, 0),firstStringCharsOccurences.get(c)));
}

    StringBuilder answer = new StringBuilder();

    for( Character c: total.keySet() ) {
    char stringWithMostOccurrences = firstStringCharsOccurences.getOrDefault(c, 0) > secondStringCharsOccurences.getOrDefault(c, 0) ? '1' :
    ( firstStringCharsOccurences.getOrDefault(c, 0) < secondStringCharsOccurences.getOrDefault(c, 0) ? '2' : '=' );
    answer.append(stringWithMostOccurrences);
    answer.append(':');
    for(int i=0; i< total.get(c) ; i++) {
        answer.append(c);
    }
    answer.append('/');
}
    return answer.toString();
}

}