import java.util.*;

public class Iterate{
    private <T> void method1(int classA, List<T> L){
        for (T t: L) {
            System.out.println(t);
        }
    }
    public static void main(String[] args) {
       List<Integer> iList = new ArrayList<Integer>();
       List<String> sList = new ArrayList<String>();
       new Iterate().method1(1, iList);
       new Iterate().method1(1, sList);
    }
}