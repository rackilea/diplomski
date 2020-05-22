package experiments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Luc Talbot
 */
public class HelloWorld {

 public static void main(String []args){
    System.out.println("Hello World");
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
    List<String> filtered = strings.stream()
                                   .filter(string -> !string.isEmpty())                        
                                   .collect(Collectors.toList());
    }
}