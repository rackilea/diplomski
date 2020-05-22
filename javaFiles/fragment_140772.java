import java.util.*;

public class HelloWorld{

public static void main(String []args){
    ArrayList<String> al = new ArrayList<String>();

    al.add("a");
    al.add("b");
    al.add("c");
    al.add("d");
    al.add("e");
    al.add("f"); // line 13


    Iterator<String> itr = al.listIterator();
    while(itr.hasNext()){
        al.remove("d"); // line 18
        if(itr.next().equals("d")){  // line 19
            //itr.remove();
            al.remove("d"); // line 21
        }

    }
    System.out.println(al);
}
}