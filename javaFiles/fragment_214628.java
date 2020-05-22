import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;


public class Main {
/**
 * @param args
 */
/*public static void main(String[] args) {
    List<Integer> intList = new ArrayList<Integer>();
    intList.add(0, new Integer(1));
    intList.add(1, new Integer(1));
    intList.add(2, new Integer(1));
    intList.add(3, new Integer(1));
    intList.add(4, new Integer(1));
    intList.add(5, new Integer(1));

}*/


public static void main(String [] args){
Vector<String> vec = new Vector<String>(); 

Hashtable<Integer, String> names=new Hashtable();
vec.addElement(new String("name1"));
vec.addElement(new String("name2"));
vec.addElement(new String("name3"));
vec.addElement(new String("name4"));
vec.addElement(new String("name5"));

int VecSize=vec.size();

for (int i=0;i<VecSize;i++){

names.put(new Integer(i), new String(vec.elementAt(i)));
}

Set set=names.keySet();
Iterator itr= set.iterator();

while (itr.hasNext()){
Integer temp = (Integer) itr.next();
System.out.println(temp+":"+names.get(temp));}
System.out.println();
}}