import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class Test {
    public static void main(String[] args) {
        List<List<Integer >> list= new ArrayList<List<Integer>>();
        List<Integer> list1=new ArrayList();
        list1.add(10);
        list1.add(20);
        list.add(list1);
        List<Integer> list2=new ArrayList();
        list2.add(60);
        list2.add(70);
        list.add(list2);
        JSONArray jsonArray= new JSONArray(list);
        System.out.println(jsonArray);  
    }


}