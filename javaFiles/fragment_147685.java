import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class HelloWorld{

 public static void main(String []args){
    List<String> list1 = new ArrayList<String>(Arrays.asList("Dog", "Cat", "Human"));
    List<String> list2 = new ArrayList<String>(Arrays.asList("Human", "Dog", "Whale", "rabbit", "Cow"));

    List<List<String>> lists=new ArrayList<List<String>>();

    lists.add(list1);
    lists.add(list2);
    Iterator<List<String>> iterator=lists.iterator();
    List<String>intersect=null;
    while(iterator.hasNext()){
        List<String> current=iterator.next();
            if(intersect==null){
              intersect=current;
            }
            else{
                intersect=intersection(intersect,current);
            }
    }
    System.out.println(intersect);
}

public static List<String> intersection(List<String> list1, List<String> list2) {
    List<String> list = new ArrayList<>();

    for (String t: list1) {
        if(list2.contains(t)) {
            list.add(t);
        }
    }

    return list;
}