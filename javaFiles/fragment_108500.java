import java.util.HashMap;
import java.util.Map;

public class MostOccuranceOfNumber {

public static void main(String[] args) {


    int[] n = {1,2,3,4,5,6,7,7,7,7};

    Map<Integer, Integer> map = new HashMap<Integer,Integer>();

    // Create Hash Map

    for(int i = 0 ; i < n.length ; i++){


        if(map.containsKey(n[i])){//you made mistake here

            map.put(n[i], map.get(n[i]) +1);

        }
        else{

            map.put(n[i], 1);
        }



    }

     }
for(Map.Entry<Integer, Integer> m : map.entrySet()){

            System.out.println("Key  "+m.getKey()+"Occured "+m.getValue()+" times ");//Sorry forgot to take it outside


 }

}