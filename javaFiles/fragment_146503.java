import java.util.Hashtable;
import lombok.ExtensionMethod;
import propel.core.utils.Linq;
import java.util.List;
import lombok.Function;

@ExtensionMethod({Linq.class})
public class Main
{

  public static void main(String[] args)
  {
    Hashtable t1=new Hashtable();
    t1.put("StdID","A1");
    t1.put("RollNo","23");
    t1.put("Class","First");
    Hashtable t2=new Hashtable();
    t2.put("StdID","A2");
    t2.put("RollNo","13");
    t2.put("Class","First");
    Hashtable t3=new Hashtable();
    t3.put("StdID","A3");
    t3.put("RollNo","53");
    t3.put("Class","Second");
    Hashtable t4=new Hashtable();
    t4.put("StdID","A4");
    t4.put("RollNo","33");
    t4.put("Class","Third");

    Hashtable main = new Hashtable();
    main.put(new Integer(1), t1);
    main.put(new Integer(2), t2);
    main.put(new Integer(3), t3);
    main.put(new Integer(4), t4);

    List<Hashtable> result= main.values().where(classEquals("First")).toList();
    for(Hashtable ht : result)
      System.out.println(ht.get("StdID"));
  }


  @Function
  private static Boolean classEquals(Hashtable table, String _class) {
    return table.get("Class") != null && table.get("Class").equals(_class);
  }
}