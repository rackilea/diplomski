import java.util.ArrayList;
import java.util.Iterator;

public class Lab8 {
    public static void main(String str[]) {
        ArrayList<String> list=new ArrayList<String>();
        list.add("sri");
        list.add("Nivas");
        list.add("Dande");
        list.add("JLC");
        System.out.println(list);

        Iterator<String> it=list.iterator();
        while(it.hasNext()) {
            Object obj=it.next();
            System.out.println(obj);
            if(obj.equals("JLC")) 
                it.remove();
        }
        System.out.println(list);
    }
}