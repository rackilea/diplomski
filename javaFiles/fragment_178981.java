import java.util.*;

public class ArrayListFromNameList {

    public static void main(String[] args){

        List<String> nameList = new ArrayList<String>(){{
            add("boom");
            add("pow");
            add("bang");
        }};  

        Map<String, List<String> > vars  = new HashMap<String, List<String>>();

        for(int i=0; i<nameList.size(); i++){

           String key = nameList.get(i);
           List<String> value = new ArrayList<String>();
           vars.put(key, value);
        } 

    }

  /* Use the Map vars like this -
  * vars.get("boom") --> will reuturns you an ArrayList<String>();
  * similarly vars.get("pow") --> will returns you an ArrayList<String>();
  */
}